package com.managepro.repository;

import java.sql.SQLException;

import com.managepro.core.model.Cliente;

public interface ClientRepository {

	public void addCliente(Cliente cliente) throws SQLException;
	
	public Cliente findClientByCpf(String cpf) throws SQLException;
	
	public Cliente findClientById(Long id) throws SQLException;
	
}
