package com.managepro.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

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
			LocalDate data =  cliente.getDataNascimento();
			Connection connection = MySQLConnection.getConnection();
			Statement statement = connection.createStatement();
			
			String sql = "INSERT INTO cliente(nome, cpf, data_nascimento) VALUES ('" + cliente.getNome() + "', '"+ cliente.getCpf() +"', '"+ java.sql.Date.valueOf(data) +"')";
			statement.execute(sql);
			
			statement.close();
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), "Erro Na Comunica��o do sistema tente novamente mais tarde");
			System.out.println(e.getMessage());
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
			JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), "Erro Na Comunica��o do sistema tente novamente mais tarde");
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
			JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), "Erro Na Comunica��o do sistema tente novamente mais tarde");
			System.out.println(e.getMessage());
			e.printStackTrace();
		
			return null;
		}
	}
}