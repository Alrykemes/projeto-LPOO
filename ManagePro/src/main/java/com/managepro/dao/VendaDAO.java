package com.managepro.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.managepro.core.model.FormaPagamento;
import com.managepro.core.model.ProdutoVendaDetails;
import com.managepro.core.model.Venda;
import com.managepro.exceptions.ExcecaoDoSistema;
import com.managepro.repository.MySQLConnection;
import com.managepro.repository.SaleRepository;

public class VendaDAO implements SaleRepository {

	private ProdutoDAO produtoDAO;
	private FuncionarioDAO funcionarioDAO;
	private ClienteDAO clienteDAO;

	public VendaDAO() {
		produtoDAO = new ProdutoDAO();
		funcionarioDAO = new FuncionarioDAO();
		clienteDAO = new ClienteDAO();
	}

	public void cadastrarVenda(Venda venda) throws SQLException, ExcecaoDoSistema {
		try {

			Connection connection = MySQLConnection.getConnection();
			PreparedStatement statementVenda = connection.prepareStatement(
					"INSERT INTO venda (id_funcionario, id_cliente, forma_pagamento, data_venda, preco, valor_recebido, troco) VALUES (?, ?, ?, ?, ?, ?, ?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			PreparedStatement statementProdutoVenda = connection.prepareStatement(
					"INSERT INTO produto_venda (id_venda, id_produto, quantidade, preco) VALUES (?, ?, ?, ?)");

			statementVenda.setLong(1, venda.getFuncionario().getId());
			statementVenda.setLong(2, venda.getCliente().getId());
			statementVenda.setString(3, venda.getFormaDePagamentoEnum().name());
			statementVenda.setDate(4, Date.valueOf(venda.getData()));
			statementVenda.setBigDecimal(5, venda.getPreco());
			statementVenda.setBigDecimal(6, venda.getValorRecebido());
			statementVenda.setBigDecimal(7, venda.getTroco());

			statementVenda.execute();

			ResultSet rs = statementVenda.getGeneratedKeys();

			while (rs.next()) {
				Long idVenda = rs.getLong(1);
				for (ProdutoVendaDetails produto : venda.getProdutosVendidos()) {

					statementProdutoVenda.setLong(1, idVenda);
					statementProdutoVenda.setLong(2, produto.getCodigoProduto());
					statementProdutoVenda.setInt(3, produto.getQuantidade());
					statementProdutoVenda.setBigDecimal(4, produto.getPreco());
					try {
						statementProdutoVenda.execute();						
					} catch (SQLException e) {
						PreparedStatement stmtDelete = connection.prepareStatement("DELETE FROM venda v WHERE v.id_venda = ?");
						stmtDelete.setLong(1, idVenda);
						stmtDelete.execute();
						throw new SQLException(e.getMessage(), e.getCause());
					}
				}
			}

			connection.close();
			statementVenda.close();
			statementProdutoVenda.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new ExcecaoDoSistema("Ocorreu um erro na comunicação do sistema.", e);
		}
	}

	public void deletarVenda(Long id) throws ExcecaoDoSistema {

		try {
			Connection connection = MySQLConnection.getConnection();
			PreparedStatement statementDeletarProduto = connection
					.prepareStatement("DELETE FROM produto_venda WHERE id_venda = ?");
			PreparedStatement statementDeletarVendas = connection
					.prepareStatement("DELETE FROM venda WHERE id_venda = ?");

			statementDeletarProduto.setLong(1, id);
			statementDeletarVendas.setLong(1, id);

			statementDeletarProduto.execute();
			statementDeletarVendas.execute();

			statementDeletarProduto.close();
			statementDeletarVendas.close();
			connection.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			throw new ExcecaoDoSistema("Ocorreu um erro na comunicação do sistema.", e);
		}
	}

	@Override
	public List<Venda> pesquisarVendaPorId(Long id) throws ExcecaoDoSistema {

		try {
			Connection connection = MySQLConnection.getConnection();
			Statement statement = connection.createStatement();

			String sql = "SELECT * FROM venda v WHERE v.id_venda LIKE '" + id + "%'";

			ResultSet resultSet = statement.executeQuery(sql);

			List<Venda> vendas = new ArrayList<>();

			while (resultSet.next()) {

				Venda venda = new Venda();

				venda.setId(resultSet.getLong("id_venda"));
				venda.setFuncionario(funcionarioDAO.encontrarFuncionarioPeloId((resultSet.getLong("id_funcionario"))));
				venda.setCliente(clienteDAO.findClientById(resultSet.getLong("id_cliente")));
				venda.setFormaDePagamentoEnum(FormaPagamento.valueOf(resultSet.getString("forma_pagamento")));
				venda.setData(resultSet.getDate("data_venda").toLocalDate());
				venda.setPreco(resultSet.getBigDecimal("preco"));
				venda.setValorRecebido(resultSet.getBigDecimal("valor_recebido"));
				venda.setTroco(resultSet.getBigDecimal("troco"));
				venda.setProdutosVendidos(produtoDAO.getProductsForSale(venda.getId()));

				vendas.add(venda);
			}

			connection.close();
			statement.close();
			resultSet.close();

			return vendas;

		} catch (SQLException | ClassNotFoundException e) {
			throw new ExcecaoDoSistema("Ocorreu um erro na comunicação do sistema.", e);
		}
	}

	@Override
	public List<Venda> listarVendasPorIdFuncionario(Long idFuncionario) throws ExcecaoDoSistema {

		try {
			Connection connection = MySQLConnection.getConnection();
			Statement statement = connection.createStatement();

			String sql = "SELECT v.id_venda, v.id_funcionario, v.id_cliente, v.forma_pagamento, v.data_venda, v.preco, v.valor_recebido, v.troco"
					+ "FROM venda v WHERE v.id_funcionario LIKE '" + idFuncionario + "%'";

			ResultSet resultSet = statement.executeQuery(sql);

			List<Venda> vendas = new ArrayList<>();

			while (resultSet.next()) {

				Venda venda = new Venda();

				venda.setId(resultSet.getLong("id_venda"));
				venda.setFuncionario(funcionarioDAO.encontrarFuncionarioPeloId(resultSet.getLong("id_funcionario")));
				venda.setCliente(clienteDAO.findClientById(resultSet.getLong("id_cliente")));
				venda.setFormaDePagamentoEnum(FormaPagamento.valueOf(resultSet.getString("forma_pagamento")));
				venda.setData(resultSet.getDate("data_venda").toLocalDate());
				venda.setPreco(resultSet.getBigDecimal("preco"));
				venda.setValorRecebido(resultSet.getBigDecimal("valor_recebido"));
				venda.setTroco(resultSet.getBigDecimal("troco"));
				venda.setProdutosVendidos(produtoDAO.getProductsForSale(venda.getId()));

				vendas.add(venda);
			}
			resultSet.close();
			statement.close();
			connection.close();

			return vendas;

		} catch (SQLException | ClassNotFoundException e) {
			throw new ExcecaoDoSistema("Ocorreu um erro na comunicação do sistema.", e);
		}
	}

	@Override
	public List<Venda> listarVendasPorIntervaloDeData(LocalDate de, LocalDate ate) throws ExcecaoDoSistema {
		try {
			Connection connection = MySQLConnection.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM venda WHERE data_venda BETWEEN ? AND ?;");

			statement.setDate(1, Date.valueOf(de));
			statement.setDate(2, Date.valueOf(ate));

			ResultSet resultSet = statement.executeQuery();

			List<Venda> vendas = new ArrayList<>();

			while (resultSet.next()) {

				Venda venda = new Venda();

				venda.setId(resultSet.getLong("id_venda"));
				venda.setFuncionario(funcionarioDAO.encontrarFuncionarioPeloId(resultSet.getLong("id_funcionario")));
				venda.setCliente(clienteDAO.findClientById(resultSet.getLong("id_cliente")));
				venda.setFormaDePagamentoEnum(FormaPagamento.valueOf(resultSet.getString("forma_pagamento")));
				venda.setData(resultSet.getDate("data_venda").toLocalDate());
				venda.setPreco(resultSet.getBigDecimal("preco"));
				venda.setValorRecebido(resultSet.getBigDecimal("valor_recebido"));
				venda.setTroco(resultSet.getBigDecimal("troco"));
				venda.setProdutosVendidos(produtoDAO.getProductsForSale(venda.getId()));

				vendas.add(venda);
			}
			resultSet.close();
			statement.close();
			connection.close();

			return vendas;

		} catch (SQLException | ClassNotFoundException e) {
			throw new ExcecaoDoSistema("Ocorreu um erro na comunicação do sistema.", e);
		}
	}

	@Override
	public List<Venda> listarTodasAsVendas() throws ExcecaoDoSistema {
		try {
			Connection connection = MySQLConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM venda");

			ResultSet resultSet = statement.executeQuery();

			List<Venda> vendas = new ArrayList<>();

			while (resultSet.next()) {

				Venda venda = new Venda();

				venda.setId(resultSet.getLong("id_venda"));
				venda.setFuncionario(funcionarioDAO.encontrarFuncionarioPeloId(resultSet.getLong("id_funcionario")));
				venda.setCliente(clienteDAO.findClientById(resultSet.getLong("id_cliente")));
				venda.setFormaDePagamentoEnum(FormaPagamento.valueOf(resultSet.getString("forma_pagamento")));
				venda.setData(resultSet.getDate("data_venda").toLocalDate());
				venda.setPreco(resultSet.getBigDecimal("preco"));
				venda.setValorRecebido(resultSet.getBigDecimal("valor_recebido"));
				venda.setTroco(resultSet.getBigDecimal("troco"));
				venda.setProdutosVendidos(produtoDAO.getProductsForSale(venda.getId()));

				vendas.add(venda);
			}
			resultSet.close();
			statement.close();
			connection.close();

			return vendas;

		} catch (SQLException | ClassNotFoundException e) {
			throw new ExcecaoDoSistema("Ocorreu um erro na comunicação do sistema.", e);
		}
	}

	public List<Venda> listarVendasPorCpfCliente(String cpf) throws ExcecaoDoSistema {
		try {
			Connection connection = MySQLConnection.getConnection();
			Statement statement = connection.createStatement();

			String sql = "SELECT v.id_venda, v.id_funcionario, v.id_cliente, v.forma_pagamento, v.data_venda, v.preco "
					+ "FROM venda v " + "JOIN cliente c ON v.id_cliente = c.id_cliente " + "WHERE c.cpf LIKE '" + cpf
					+ "%'";

			ResultSet resultSet = statement.executeQuery(sql);

			List<Venda> vendas = new ArrayList<>();

			while (resultSet.next()) {

				Venda venda = new Venda();

				venda.setId(resultSet.getLong("id_venda"));
				venda.setFuncionario(funcionarioDAO.encontrarFuncionarioPeloId((resultSet.getLong("id_funcionario"))));
				venda.setCliente(clienteDAO.findClientById(resultSet.getLong("id_cliente")));
				venda.setFormaDePagamentoEnum(FormaPagamento.valueOf(resultSet.getString("forma_pagamento")));
				venda.setData(resultSet.getDate("data_venda").toLocalDate());
				venda.setPreco(resultSet.getBigDecimal("preco"));
				venda.setProdutosVendidos(produtoDAO.getProductsForSale(venda.getId()));

				vendas.add(venda);
			}
			connection.close();
			statement.close();
			resultSet.close();

			return vendas;

		} catch (SQLException | ClassNotFoundException e) {
			throw new ExcecaoDoSistema("Ocorreu um erro na comunicação do sistema.", e);
		}
	}

	public void gerarRelatorioDiario() throws ExcecaoDoSistema {
		try {
			Connection connection = MySQLConnection.getConnection();
			Statement statement = connection.createStatement();

			String sql = "CALL managepro_bd.AtualizarEstatisticaPorData(" + Date.valueOf(LocalDate.now()) + ");";

			statement.execute(sql);

			connection.close();
			statement.close();
		} catch (SQLException | ClassNotFoundException e) {
			throw new ExcecaoDoSistema("Ocorreu um erro na comunicação do sistema.", e);
		}
	}
}