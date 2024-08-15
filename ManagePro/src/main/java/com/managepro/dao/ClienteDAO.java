package com.managepro.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.managepro.core.model.Cliente;
import com.managepro.repository.ClientRepository;
import com.managepro.repository.MySQLConnection;
import com.managepro.ui.Janela;

public class ClienteDAO implements ClientRepository{
	
	private Cliente cliente;
	
	@Override
	public void addCliente(Cliente cliente) throws SQLException {
		
		
	}

	@Override
	public Cliente findClientByCpf(String cpf) {
		
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
			
			statement.close(); 
			connection.close();
			
			return cliente;
			
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(Janela.getInstace().getPanelPrincipal(), "Erro Na Comunicação do sistema tente novamente mais tarde");
			System.out.println(e.getMessage());
		
			return cliente;
		}
	}

}
