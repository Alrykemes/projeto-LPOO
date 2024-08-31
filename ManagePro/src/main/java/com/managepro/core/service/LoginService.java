package com.managepro.core.service;

import com.managepro.core.model.Funcionario;
import com.managepro.dao.*;
import com.managepro.exceptions.ExcecaoDoSistema;
import com.managepro.exceptions.ValidacaoException;
import com.managepro.ui.Janela;

public class LoginService {
    private FuncionarioDAO FuncionarioDAO;
    
    public LoginService() {
        this.FuncionarioDAO = new FuncionarioDAO();
    }
    
    public boolean authenticate(String usuario, String senha) throws ExcecaoDoSistema, ValidacaoException {
        Funcionario funcionario = FuncionarioDAO.encontrarFuncionarioPeloUsuario(usuario);
        if(funcionario == null || funcionario.getUsuario() == null) {
        	throw new ValidacaoException("Usuário ou senha Incorreto!");
        }
        Janela.getInstance().getTelaLogin().setFuncionarioLogado(funcionario);
        Janela.getInstance().getTelaNovaVenda().getLabelFuncionarioJLabel().setText(funcionario.getNome());
        return funcionario.getSenha().equals(senha);
    }
    
    public boolean verificarSenha(String senha) {
    	return senha.equals("Master@#123");
		}
    }