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

import com.managepro.core.model.Produto;
import com.managepro.core.model.ProdutoVendaDetails;
import com.managepro.exceptions.ExcecaoDoSistema;
import com.managepro.repository.MySQLConnection;
import com.managepro.repository.ProductRepository;

public class ProdutoDAO  implements ProductRepository{
	
	private Produto produto;
	private ProdutoVendaDetails produtoVendaDetails;
	private Connection connection;
	private PreparedStatement statement;
	
	public Produto findProductById(Long id) throws ExcecaoDoSistema {
		try {
		Connection connection = MySQLConnection.getConnection();
		Statement stmt = connection.createStatement();
		
		String sql = "SELECT * FROM produto WHERE id_produto = " + id + ";";
		 
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			produto = new Produto();
			produto.setCodigoProduto(rs.getLong("id_produto"));
			produto.setNomeProduto(rs.getString("nome"));
			produto.setQuantidade(rs.getInt("quantidade"));
			produto.setMarca(rs.getString("marca"));
			produto.setPreco(rs.getBigDecimal("preco"));;
			produto.setValidade(rs.getDate("validade").toLocalDate());
		}
		
		return produto;
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new ExcecaoDoSistema("Ocorreu um erro na comunicação do sistema.", e); 
		}
		}
	
	
	
		
		public void newProduct(Produto produto) throws ExcecaoDoSistema {
			try {
				connection = MySQLConnection.getConnection();
				statement = connection.prepareStatement("INSERT INTO produto (nome,preco,quantidade,marca,fornecedor,validade) VALUES (?,?,?,?,?,?)");
				statement.setString(1, produto.getNomeProduto());
				statement.setBigDecimal(2, produto.getPreco());
				statement.setInt(3, produto.getQuantidade());
				statement.setString(4, produto.getMarca());
				statement.setString(5, produto.getFornecedor());
				statement.setDate(6, Date.valueOf(produto.getValidade()));
				statement.execute();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				throw new ExcecaoDoSistema("Ocorreu um erro na comunicação do sistema.", e); 
			}
		}

		
		public Produto editarProduto(Produto produto) throws ExcecaoDoSistema {
			try {
				connection = MySQLConnection.getConnection();
				statement = connection.prepareStatement("UPDATE produto SET nome = ?,preco = ?,quantidade = ?,marca = ?,fornecedor = ?,validade = ? WHERE id_produto = '" + produto.getCodigoProduto() + "'");
				statement.setString(1, produto.getNomeProduto());
				statement.setBigDecimal(2, produto.getPreco());
				statement.setInt(3, produto.getQuantidade());
				statement.setString(4, produto.getMarca());
				statement.setString(5, produto.getFornecedor());
				statement.setDate(6, Date.valueOf(produto.getValidade()));
				statement.execute();
				return null;
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				throw new ExcecaoDoSistema("Ocorreu um erro na comunicação do sistema.", e); 
			}
			}
		

		
		public void removerProduto(Long id) throws ExcecaoDoSistema {
			try {
				connection = MySQLConnection.getConnection();
				statement = connection.prepareStatement("DELETE FROM produto WHERE id_produto = ?");
				statement.setLong(1, id);
				statement.execute();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				throw new ExcecaoDoSistema("Ocorreu um erro na comunicação do sistema.", e); 
			}
			}
		

		@Override
		public List<Produto> pesquisarProdutoNome(String nomeProduto) throws ExcecaoDoSistema {
			try {	
				connection = MySQLConnection.getConnection();
				statement = connection.prepareStatement("SELECT * FROM produto WHERE nome LIKE ?");
				statement.setString(1, "%" + nomeProduto + "%");
				ResultSet rs = statement.executeQuery();
				List<Produto> produtos = new ArrayList<>();
				while (rs.next()) {
				    Produto produto = new Produto();
				    produto.setCodigoProduto(rs.getLong("id_produto"));
				    produto.setNomeProduto(rs.getString("nome"));
				    produto.setFornecedor(rs.getString("fornecedor"));
				    produto.setQuantidade(rs.getInt("quantidade"));
				    produto.setMarca(rs.getString("marca"));
				    produto.setPreco(rs.getBigDecimal("preco"));
				    produto.setValidade(rs.getDate("validade").toLocalDate());
				    produtos.add(produto);
				}
				return produtos;
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				throw new ExcecaoDoSistema("Ocorreu um erro na comunicação do sistema.", e); 
			}
			}
		
		
		public List<Produto> pesquisarProdutoID(Long id_produto) throws ExcecaoDoSistema {
			try {	
				connection = MySQLConnection.getConnection();
				statement = connection.prepareStatement("SELECT * FROM produto WHERE id_produto = ?");
				statement.setLong(1, id_produto);
				ResultSet rs = 	statement.executeQuery();		
				List<Produto> produtos = new ArrayList<>();
				while (rs.next()) {
					Produto produto = new Produto();
					produto.setCodigoProduto(rs.getLong("id_produto"));
					produto.setNomeProduto(rs.getString("nome"));
					produto.setFornecedor(rs.getString("fornecedor"));
					produto.setQuantidade(rs.getInt("quantidade"));
					produto.setMarca(rs.getString("marca"));
					produto.setPreco(rs.getBigDecimal("preco"));;
					produto.setValidade(rs.getDate("validade").toLocalDate());
					produtos.add(produto);
					
				}
						
				return produtos;
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				throw new ExcecaoDoSistema("Ocorreu um erro na comunicação do sistema.", e); 
			}
		}

		@Override
		public List<ProdutoVendaDetails> getProductsForSale(Long idVenda) throws ExcecaoDoSistema {
			
			try {
				
				List<ProdutoVendaDetails> produtos = new ArrayList<>();
				connection = MySQLConnection.getConnection();
				PreparedStatement stmt = connection.prepareStatement("SELECT pv.id_produto, p.nome, pv.quantidade, pv.preco FROM produto_venda AS pv"
						+ " INNER JOIN produto AS p ON p.id_produto = pv.id_produto WHERE pv.id_venda = ?");
				
				stmt.setLong(1, idVenda);
				
				ResultSet rs = stmt.executeQuery();
				
				while (rs.next()) {
					produtoVendaDetails = new ProdutoVendaDetails();
					produtoVendaDetails.setCodigoProduto(rs.getLong("id_produto"));
					produtoVendaDetails.setNomeProduto(rs.getString("nome"));
					produtoVendaDetails.setQuantidade(rs.getInt("quantidade"));
					produtoVendaDetails.setPreco(rs.getBigDecimal("preco"));
					produtos.add(produtoVendaDetails);
				}
				
				return produtos;
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				throw new ExcecaoDoSistema("Ocorreu um erro na comunicação do sistema.", e); 
			}
		}



		@Override
		public List<Produto> getTodosProdutos() throws ExcecaoDoSistema {
			try {	
				connection = MySQLConnection.getConnection();
				statement = connection.prepareStatement("SELECT * FROM produto;");
				ResultSet rs = 	statement.executeQuery();		
				List<Produto> produtos = new ArrayList<>();
				while (rs.next()) {
					produto = new Produto();
					produto.setCodigoProduto(rs.getLong("id_produto"));
					produto.setNomeProduto(rs.getString("nome"));
					produto.setFornecedor(rs.getString("fornecedor"));
					produto.setQuantidade(rs.getInt("quantidade"));
					produto.setMarca(rs.getString("marca"));
					produto.setPreco(rs.getBigDecimal("preco"));;
					produto.setValidade(rs.getDate("validade").toLocalDate());
					produtos.add(produto);
					
				}
						
				return produtos;
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				throw new ExcecaoDoSistema("Ocorreu um erro na comunicação do sistema.", e); 
			}
		}



		@Override
		public List<Produto> pesquisarProdutoValidade(LocalDate validade) throws ClassNotFoundException, SQLException, ExcecaoDoSistema {
			try {	
				connection = MySQLConnection.getConnection();
				statement = connection.prepareStatement("SELECT * FROM produto WHERE validade = ?");
				statement.setDate(1, Date.valueOf(validade));
				ResultSet rs = 	statement.executeQuery();		
				List<Produto> product = new ArrayList<>();
				while (rs.next()) {
					produto = new Produto();
					produto.setCodigoProduto(rs.getLong("id_produto"));
					produto.setNomeProduto(rs.getString("nome"));
					produto.setFornecedor(rs.getString("fornecedor"));
					produto.setQuantidade(rs.getInt("quantidade"));
					produto.setMarca(rs.getString("marca"));
					produto.setPreco(rs.getBigDecimal("preco"));;
					produto.setValidade(rs.getDate("validade").toLocalDate());
					product.add(produto);
					
				}
						
				return product;
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				throw new ExcecaoDoSistema("Ocorreu um erro na comunicação do sistema.", e); 
			}
		}
	}