package com.managepro.dao;

import java.sql.Connection;
import java.sql.Date;
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
			Date sqlDate = java.sql.Date.valueOf(data);
			
			Connection connection = MySQLConnection.getConnection();
			Statement statement = connection.createStatement();
			String sql = "INSERT INTO cliente(nome, cpf, data_nascimento) VALUES ('" + cliente.getNome() + "', '"+ cliente.getCpf() +"', '"+ sqlDate +"')";
			statement.execute(sql);
			statement.close();
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(Janela.getInstace().getPanelPrincipal(), "Erro Na Comunicação do sistema tente novamente mais tarde");
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public Cliente findClientByCpf(String cpf){
		try {
			Connection connection = MySQLConnection.getConnection();
			Statement statement = connection.createStatement();
			
			String sql = "SELECT * FROM cliente c WHERE c.cpf = '" + cpf + "'";
			ResultSet rs = statement.executeQuery(sql);
			
			if(rs.next()) {
				cliente = new Cliente();
				cliente.setId(rs.getLong("id_cliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setDataNascimento((rs.getDate("data_nascimento").toLocalDate()));
			}
				
			if(cliente == null) {
				return new Cliente(null, null, null, null);
			}
			
			String sql2 = "SELECT numero FROM telefone_cliente t WHERE t.id_cliente = '" + cliente.getId() + "'";
			ResultSet rs2 = statement.executeQuery(sql2);
			
			if(rs2.next()) {
				cliente.setTelefone(rs2.getString("numero"));
			}
			
			statement.close(); 
			connection.close();
			
			return cliente;
			
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(Janela.getInstace().getPanelPrincipal(), "Erro Na Comunicação do sistema tente novamente mais tarde");
			System.out.println(e.getMessage());
			e.printStackTrace();
		
			return cliente;
		}
	}
}
