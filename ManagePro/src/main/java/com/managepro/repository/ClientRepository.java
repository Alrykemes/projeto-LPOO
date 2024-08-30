package com.managepro.repository;

import com.managepro.core.model.Cliente;
import com.managepro.exceptions.ExcecaoDoSistema;

public interface ClientRepository {

	public void addCliente(Cliente cliente) throws ExcecaoDoSistema;
	
	public Cliente findClientByCpf(String cpf) throws ExcecaoDoSistema;
	
	public Cliente findClientById(Long id) throws ExcecaoDoSistema;
	
}
