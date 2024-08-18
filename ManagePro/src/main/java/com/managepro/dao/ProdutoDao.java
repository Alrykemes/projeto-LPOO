package com.managepro.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.managepro.core.model.Produto;
import com.managepro.repository.MySQLConnection;
import com.managepro.repository.ProductRepository;

public class ProdutoDao implements ProductRepository {
	
	
	private Produto produto;
	private Connection connection;
	private PreparedStatement statement;


	public void newProduct(Produto produto) throws ClassNotFoundException, SQLException {

		connection = MySQLConnection.getConnection();
		statement = connection.prepareStatement("INSERT INTO produto (nome,preco,quantidade,marca,fornecedor,validade) VALUES (?,?,?,?,?,?)");
		statement.setString(1, produto.getNomeProduto());
		statement.setBigDecimal(2, produto.getPreco());
		statement.setInt(3, produto.getQuantidade());
		statement.setString(4, produto.getMarca());
		statement.setString(5, produto.getFornecedor());
		statement.setDate(6, Date.valueOf(produto.getValidade()));
		statement.execute();
	}

	
	public Produto editarProduto(Produto produto) throws ClassNotFoundException, SQLException {
		connection = MySQLConnection.getConnection();
		statement = connection.prepareStatement("UPDATE produto SET nome = ?,preco = ?,quantidade = ?,marca = ?,fornecedor = ?,validade = ?");
		statement.setString(1, produto.getNomeProduto());
		statement.setBigDecimal(2, produto.getPreco());
		statement.setInt(3, produto.getQuantidade());
		statement.setString(4, produto.getMarca());
		statement.setString(5, produto.getFornecedor());
		statement.setDate(6, Date.valueOf(produto.getValidade()));
		statement.execute();
		return produto;
	}

	
	public void removerProduto(Long id) throws ClassNotFoundException, SQLException {
		connection = MySQLConnection.getConnection();
		statement = connection.prepareStatement("DELETE FROM produto WHERE id_produto = ?");
		statement.setLong(1, id);
		statement.execute();
		
	}


	@Override
	public List<Produto> pesquisarProdutoNome(String nomeProduto) throws ClassNotFoundException, SQLException {
		connection = MySQLConnection.getConnection();
		statement = connection.prepareStatement("SELECT * FROM produto WHERE nome LIKE ?");
		statement.setString(1,"%" + nomeProduto + "%");
		ResultSet rs = 	statement.executeQuery();		
		List<Produto> product = new ArrayList<>();
		while (rs.next()) {
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
	}
	
	
	public List<Produto> pesquisarProdutoID(Long id_produto) throws ClassNotFoundException, SQLException {
		connection = MySQLConnection.getConnection();
		statement = connection.prepareStatement("SELECT * FROM produto WHERE id_produto = ?");
		statement.setLong(1, id_produto);
		ResultSet rs = 	statement.executeQuery();		
		List<Produto> product = new ArrayList<>();
		while (rs.next()) {
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
	}


}
