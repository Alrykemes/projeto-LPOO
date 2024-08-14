package com.managepro.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import com.managepro.core.model.Cliente;
import com.managepro.repository.ClientRepository;
import com.managepro.repository.MySQLConnection;

public class ClienteDAO implements ClientRepository{
	
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
			
			Cliente cliente = new Cliente();
			if(rs.next()) {

				cliente.setId(rs.getLong("id_cliente"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setDataNascimento(LocalDate.of(2005, 8, 13));
				
			}
			
			statement.close(); 
			connection.close();
			
			if (cliente.getCpf() == null) {
				return null;
			}
			return cliente;
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
