package com.managepro.repository;

import java.util.List;

import com.managepro.core.model.Funcionario;
import com.managepro.exceptions.ExcecaoDoSistema;

public interface FuncionarioRepository {

	public Funcionario encontrarFuncionarioPeloUsuario(String user) throws ExcecaoDoSistema;
	
	public Funcionario encontrarFuncionarioPeloId(Long id) throws ExcecaoDoSistema;
	
	public Funcionario encontrarFuncionarioPeloCpf(String cpf) throws ExcecaoDoSistema;
	
	public void adicionarFuncionario(Funcionario funcionario) throws ExcecaoDoSistema;
	
	public boolean editarFuncionario(Funcionario funcionario, Funcionario funcionario2) throws ExcecaoDoSistema;
	
	public boolean removerFuncionario(Long idFuncionario) throws ExcecaoDoSistema;

	List<Funcionario> listaDeFuncionarios() throws ExcecaoDoSistema;
}