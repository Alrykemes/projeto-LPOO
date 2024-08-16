package com.managepro.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.managepro.core.model.Produto;
import com.managepro.repository.MySQLConnection;
import com.managepro.repository.ProductRepository;
import com.managepro.ui.Janela;

public class ProdutoDAO  implements ProductRepository{
	
	private Produto produto;
	
	public Produto findProductById(Long id) {
		try {
		Connection connection = MySQLConnection.getConnection();
		Statement stmt = connection.createStatement();
		
		String sql = "SELECT * FROM produto WHERE id_produto = " + id + ";";
		 
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			produto = new Produto();
			produto.setCodigoProduto(rs.getLong("id_produto"));
			System.out.println(produto.getCodigoProduto());
			produto.setNomeProduto(rs.getString("nome"));
			produto.setQuantidade(rs.getInt("quantidade"));
			produto.setMarca(rs.getString("marca"));
			produto.setPreco(rs.getBigDecimal("preco"));;
			produto.setValidade(rs.getDate("validade").toLocalDate());
		}
		
		return produto;
		
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(Janela.getInstace().getPanelPrincipal(), "Erro Na Comunicação do sistema tente novamente mais tarde");
			System.out.println(e.getMessage());
			return null;
		}
	}
}