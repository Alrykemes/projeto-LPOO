package com.managepro.core.service;

import java.util.List;

import javax.swing.JOptionPane;

import com.managepro.core.model.Funcionario;
import com.managepro.dao.FuncionarioDAO;
import com.managepro.ui.Janela;

public class FuncionarioService {
	
	private FuncionarioDAO funcionarioDAO;
	
	public FuncionarioService() {
		funcionarioDAO = new FuncionarioDAO();
	}
	
	public void criarFuncionario(Funcionario funcionario) throws Exception {
		if (validarCampos(funcionario)) {
			if (funcionarioDAO.encontrarFuncionarioPeloCpf(funcionario.getCpf()) != null) {
				JOptionPane.showMessageDialog(Janela.getInstance().getFrame(), "Funcionário já cadastrado");
			} else {
				funcionarioDAO.adicionarFuncionario(funcionario);
				JOptionPane.showMessageDialog(Janela.getInstance().getFrame(), "Funcionário cadastrado");
			}
		} else {
			throw new Exception("Erro");
		}
	}
	
	public boolean validarCampos(Funcionario funcionario) throws Exception {
		if (funcionario.getNome().length() <= 6 || funcionario.getNome().length() >= 69) {
			throw new Exception("Erro, o nome inserido não é válido");
		}
		
		if (funcionario.getCpf().length() != 14) {
			throw new Exception("CPF inválido");
		}
		
		if (funcionario.getUsuario().length() < 5) {
			throw new Exception("Usuário muito curto");
		}
		
		if (funcionario.getSenha().length() < 5) {
			throw new Exception("Senha muito curta");
		}
		return true;
	}
	
	public List<Funcionario> obterTodosFuncionarios() {
	    return funcionarioDAO.listaDeFuncionarios();
	}
}
