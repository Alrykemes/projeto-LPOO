package com.managepro.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.managepro.core.model.FormaPagamento;
import com.managepro.core.model.ProdutoVendaDetails;
import com.managepro.core.model.Venda;
import com.managepro.repository.MySQLConnection;
import com.managepro.repository.SaleRepository;
import com.managepro.ui.Janela;

public class VendaDAO implements SaleRepository {
	
	private ProdutoDAO produtoDAO;
	private FuncionarioDAO funcionarioDAO;
	private ClienteDAO clienteDAO;
	
	public VendaDAO() {
		produtoDAO = new ProdutoDAO();
		funcionarioDAO = new FuncionarioDAO();
		clienteDAO = new ClienteDAO();
	}
	
	public void cadastrarVenda(Venda venda) {
		   try {
		        
			   Connection connection = MySQLConnection.getConnection();
			   PreparedStatement statementVenda = connection.prepareStatement("INSERT INTO venda (id_funcionario, id_cliente, forma_pagamento, data_venda, preco) VALUES (?, ?, ?, ?, ?)");
			   PreparedStatement statementProdutoVenda = connection.prepareStatement("INSERT INTO produto_venda (id_venda, id_produto, quantidade, preco) VALUES (?, ?, ?, ?)");
			   
		       statementVenda.setLong(1, venda.getFuncionario().getId());
		       statementVenda.setLong(2, venda.getCliente().getId());
		       statementVenda.setString(3, venda.getFormaDePagamentoEnum().name());
		       statementVenda.setDate(4, Date.valueOf(venda.getData())); 
		       statementVenda.setBigDecimal(5, venda.getPreco());
		
		       statementVenda.execute();
		
		       PreparedStatement stmtGetId = connection.prepareStatement("SELECT v.id_venda FROM venda v WHERE v.data_venda = ?");
		   	
		        stmtGetId.setDate(1, Date.valueOf(venda.getData()));
		        
		        ResultSet rs =  stmtGetId.executeQuery();
		        
		        Long idVenda = null;
		        
		        while(rs.next()) {
		        	
		       idVenda = rs.getLong("id_venda");
		        	
		        }
		        
		       for (ProdutoVendaDetails produto : venda.getProdutosVendidos()) {
		    	   
		    	   statementProdutoVenda.setLong(1, idVenda); 
		           statementProdutoVenda.setLong(2, produto.getCodigoProduto());
		           statementProdutoVenda.setInt(3, produto.getQuantidade());
		           statementProdutoVenda.setBigDecimal(4, produto.getPreco());
		
		           statementProdutoVenda.execute();
		       }
		       
		       connection.close();
		       statementVenda.close();
		       statementProdutoVenda.close();
	    } catch (SQLException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), "Erro Na Comunica��o do sistema tente novamente mais tarde");
			System.out.println(e.getMessage());
	        e.printStackTrace();
	    }
	}
	
	public void pesquisarVendasPorId(Long id) throws ClassNotFoundException, SQLException {
	
	    try {
	    	
	    	Connection connection = MySQLConnection.getConnection();
	    	PreparedStatement statementReceberVendas = connection.prepareStatement("SELECT v.id_venda, v.id_funcionario, v.id_cliente, v.forma_pagamento, v.data_venda, v.preco FROM venda v WHERE v.id_venda = ?");
	
	        statementReceberVendas.setLong(1, id);
	        statementReceberVendas.execute();
	
	        statementReceberVendas.close();
	        connection.close();
	        
	    } catch (SQLException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), "Erro Na Comunica��o do sistema tente novamente mais tarde");
			System.out.println(e.getMessage());
	        e.printStackTrace(); 
	    }
	}
	
	
	
	
	public void deletarVendas(Long Id) throws ClassNotFoundException, SQLException {
	
	    try {
	    	Connection connection = MySQLConnection.getConnection();
	    	PreparedStatement statementDeletarProduto = connection.prepareStatement("DELETE FROM produto_venda WHERE id_venda = ?");
	    	PreparedStatement statementDeletarVendas = connection.prepareStatement("DELETE FROM venda WHERE id_venda = ?");
	
	        statementDeletarProduto.setLong(1, Id);
	        statementDeletarVendas.setLong(1, Id);
	
	        statementDeletarProduto.execute();
	        statementDeletarVendas.execute();
	
	        statementDeletarProduto.close();
	        statementDeletarVendas.close();
	        connection.close();
	        
	    } catch (SQLException | ClassNotFoundException e) {
	    	JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), "Erro Na Comunica��o do sistema tente novamente mais tarde");
			System.out.println(e.getMessage());
	        e.printStackTrace();  
	    } 
	}
	
	@Override
	public List<Venda> listarVendaPorId(Long Id) throws ClassNotFoundException, SQLException {
	
	    try {
	    	Connection connection = MySQLConnection.getConnection();
	    	PreparedStatement statement = connection.prepareStatement(
	            "SELECT v.id_venda, v.id_funcionario, v.id_cliente, v.forma_pagamento, v.data_venda, v.preco " +
	            "FROM venda v WHERE v.id_venda = ?"
	        );
	
	        statement.setLong(1, Id);
	        ResultSet resultSet = statement.executeQuery();
	        
	        List<Venda> vendas = new ArrayList<>();
	
	        while (resultSet.next()) {
	            
	        	Venda venda = new Venda();
	            
	            venda.setId(resultSet.getLong("id_venda"));
	            venda.setFuncionario(funcionarioDAO.findEmployeeById((resultSet.getLong("id_funcionario")))); // Implementar m�todo TO DO
	            venda.setCliente(clienteDAO.findClientById(resultSet.getLong("id_cliente"))); // Implementar m�todo
	            venda.setFormaDePagamentoEnum(FormaPagamento.valueOf(resultSet.getString("forma_pagamento")));
	            venda.setData(resultSet.getDate("data_venda").toLocalDate());
	            venda.setPreco(resultSet.getBigDecimal("preco"));
	           // venda.setProdutosVendidos(listarProdutosPorVendaId(venda.getId())); // Implementar m�todo
	
	            vendas.add(venda);
	        }
	        
	        connection.close();
	        statement.close();        
	        resultSet.close();
	        
	        return vendas;
	    
	    } catch (SQLException | ClassNotFoundException e) {
	    	JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), "Erro Na Comunica��o do sistema tente novamente mais tarde");
			System.out.println(e.getMessage());
	        e.printStackTrace(); 
	        return null;
	    } 
	}
	
	
	
	@Override
	public List<Venda> listarVendaPorFuncionario(Long idFuncionario) throws ClassNotFoundException, SQLException {
	    
		try {
	    	Connection connection = MySQLConnection.getConnection();
	    	PreparedStatement statement = connection.prepareStatement(
	                "SELECT v.id_venda, v.id_funcionario, v.id_cliente, v.forma_pagamento, v.data_venda, v.preco " +
	                        "FROM venda v WHERE v.id_funcionario = ?"
	        );
	
	        statement.setLong(1, idFuncionario);
	        ResultSet resultSet = statement.executeQuery();
	
	        List<Venda> vendas = new ArrayList<>();
	
	        while (resultSet.next()) {
	            
	        	Venda venda = new Venda();
	            
	            venda.setId(resultSet.getLong("id_venda"));
	            venda.setFuncionario(funcionarioDAO.findEmployeeById(resultSet.getLong("id_funcionario"))); 
	            venda.setCliente(clienteDAO.findClientById(resultSet.getLong("id_cliente"))); 
	            venda.setFormaDePagamentoEnum(FormaPagamento.valueOf(resultSet.getString("forma_pagamento")));
	            venda.setData(resultSet.getDate("data_venda").toLocalDate());
	            venda.setPreco(resultSet.getBigDecimal("preco"));
	          //  venda.setProdutosVendidos(listarProdutosPorVendaId(venda.getId()));
	
	            vendas.add(venda);
	        }
	        resultSet.close();
	        statement.close();
	        connection.close();
	
	        return vendas;
	
	    } catch (SQLException | ClassNotFoundException e) {
	    	JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), "Erro Na Comunica��o do sistema tente novamente mais tarde");
			System.out.println(e.getMessage());
	        e.printStackTrace();  
	        return null;
	    } 
	}
	
	
	
	@Override
	public List<Venda> listarVendasPorData(LocalDate dataVenda) throws ClassNotFoundException, SQLException {
	    try {
	    	Connection connection = MySQLConnection.getConnection();
	    	PreparedStatement statement = connection.prepareStatement(
	                "SELECT v.id_venda, v.id_funcionario, v.id_cliente, v.forma_pagamento, v.data_venda, v.preco " +
	                        "FROM venda v WHERE v.data_venda = ?"
	        );
	
	        statement.setDate(1, Date.valueOf(dataVenda));
	        ResultSet resultSet = statement.executeQuery();
	
	        List<Venda> vendas = new ArrayList<>();
	
	        while (resultSet.next()) {
	            
	        	Venda venda = new Venda();
	            
	        	venda.setId(resultSet.getLong("id_venda"));
	            venda.setFuncionario(funcionarioDAO.findEmployeeById(resultSet.getLong("id_funcionario"))); 
	            venda.setCliente(clienteDAO.findClientById(resultSet.getLong("id_cliente"))); 
	            venda.setFormaDePagamentoEnum(FormaPagamento.valueOf(resultSet.getString("forma_pagamento")));
	            venda.setData(resultSet.getDate("data_venda").toLocalDate());
	            venda.setPreco(resultSet.getBigDecimal("preco"));
	            //venda.setProdutosVendidos(listarProdutosPorVendaId(venda.getId()));
	
	            vendas.add(venda);
	        }
		    resultSet.close();
		    statement.close();
		    connection.close();
	
	        return vendas;
	
	        } catch (SQLException | ClassNotFoundException e) {
	        	JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), "Erro Na Comunica��o do sistema tente novamente mais tarde");
				System.out.println(e.getMessage());
	            e.printStackTrace();  
	            return null;
	        }
		}

	
}

