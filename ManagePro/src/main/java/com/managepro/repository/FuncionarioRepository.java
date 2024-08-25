package com.managepro.repository;

import java.sql.SQLException;
import java.util.List;

import com.managepro.core.model.Funcionario;

public interface FuncionarioRepository {

	public Funcionario encontrarFuncionarioPeloUsuario(String user) throws ClassNotFoundException, SQLException;
	
	public Funcionario encontrarFuncionarioPeloId(Long id) throws SQLException;
	
	public Funcionario encontrarFuncionarioPeloCpf(String cpf) throws SQLException;
	
	public void adicionarFuncionario(Funcionario funcionario);
	
	public void editarFuncionario(Funcionario funcionario, Funcionario funcionario2);
	
	public void removerFuncionario(Long idFuncionario);

	List<Funcionario> listaDeFuncionarios();
}
