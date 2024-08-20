package com.managepro.repository;

import java.sql.SQLException;

import com.managepro.core.model.Funcionario;

public interface EmployeeRepository {

	public Funcionario findEmployeeByUser(String user) throws ClassNotFoundException, SQLException;
	
	public Funcionario findEmployeeById(Long id) throws SQLException;
	
	public Funcionario encontrarFuncionarioPeloCpf(String cpf) throws SQLException;
	
	public void adicionarFuncionario(Funcionario funcionario);
}
