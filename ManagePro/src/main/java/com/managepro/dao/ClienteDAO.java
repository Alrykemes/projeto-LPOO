package com.managepro.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import com.managepro.core.model.Cliente;
import com.managepro.repository.ClientRepository;
import com.managepro.repository.MySQLConnection;
import com.managepro.ui.Janela;

public class ClienteDAO implements ClientRepository{
	
	private Cliente cliente;
	
	@Override
	public void addCliente(Cliente cliente) {
		try {
			Connection connection = MySQLConnection.getConnection();
			PreparedStatement stmtCliente = connection.prepareStatement(
					"INSERT INTO cliente(nome, cpf, data_nascimento) VALUES (?, ?, ?);",
					PreparedStatement.RETURN_GENERATED_KEYS);
			PreparedStatement stmtTelefone = connection.prepareStatement(
					"INSERT INTO telefone_cliente(id_cliente, numero) VALUES (?, ?);");
			
			stmtCliente.setString(1, cliente.getNome());
			stmtCliente.setString(2, cliente.getCpf());
			stmtCliente.setDate(3, Date.valueOf(cliente.getDataNascimento()));
			
			stmtCliente.executeUpdate();
			
			ResultSet rs = stmtCliente.getGeneratedKeys();
	        if (rs.next()) {
	        Long clienteId = rs.getLong(1);	        	
			
			stmtTelefone.setLong(1, clienteId);
			stmtTelefone.setString(2, cliente.getTelefone());
			
			stmtTelefone.execute();
	        } else {
				throw new SQLException("Falha ao Inserir Cliente, ID não Gerado ou nulo!");
			}
	        
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), "Erro Na Comunicação do sistema tente novamente mais tarde");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

	@Override
	public Cliente findClientByCpf(String cpf){
		try {
			
			Connection connection = MySQLConnection.getConnection();
			Statement statement = connection.createStatement();
			
			String sql = "SELECT c.id_cliente, c.nome, c.cpf, c.data_nascimento, t.numero FROM cliente AS c "
					+ "INNER JOIN telefone_cliente AS t ON t.id_cliente = c.id_cliente WHERE c.cpf = '" + cpf + "';";
			ResultSet rs = statement.executeQuery(sql);
			
			if(rs.next()) {
				cliente = new Cliente();
				cliente.setId(rs.getLong("id_cliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setTelefone(rs.getString("numero"));
				cliente.setDataNascimento((rs.getDate("data_nascimento").toLocalDate()));
			}
				
			if(cliente == null) {
				return new Cliente(null, null, null, null);
			}
			
			connection.close();
			statement.close(); 
			
			return cliente;
			
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), "Erro Na Comunicação do sistema tente novamente mais tarde");
			System.out.println(e.getMessage());
			e.printStackTrace();
		
			return cliente;
		}
	}
	
	public Cliente findClientById(Long id){
		try {
			
			Connection connection = MySQLConnection.getConnection();
			Statement statement = connection.createStatement();
			
			String sql = "SELECT c.id_cliente, c.nome, c.cpf, c.data_nascimento, t.numero FROM cliente AS c "
					+ "INNER JOIN telefone_cliente AS t ON t.id_cliente = c.id_cliente WHERE c.id_cliente = '" + id + "';";
			ResultSet rs = statement.executeQuery(sql);
			
			if(rs.next()) {
				cliente = new Cliente();
				cliente.setId(rs.getLong("id_cliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setTelefone(rs.getString("numero"));
				cliente.setDataNascimento((rs.getDate("data_nascimento").toLocalDate()));
			}
			
			connection.close();
			statement.close(); 
			
			return cliente;
			
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), "Erro Na Comunicação do sistema tente novamente mais tarde");
			System.out.println(e.getMessage());
			e.printStackTrace();
		
			return null;
		}
	}
}
