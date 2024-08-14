package com.managepro.dao;

import java.sql.Connection;
import java.sql.Date;
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
			e.printStackTrace();
		}
		
	}

	@Override
	public Cliente findClientByCpf(String cpf){
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
				
				Date sqlDate = rs.getDate("data_nascimento");
				
				if (sqlDate != null) {
					cliente.setDataNascimento(sqlDate.toLocalDate());
				}
			}
			statement.close(); 
			connection.close();
			
			if (cliente.getCpf() == null) {
				return cliente;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
