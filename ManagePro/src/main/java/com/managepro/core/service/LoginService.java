package com.managepro.core.service;

public class LoginService {
    private FuncionarioDAO FuncionarioDAO;

    public LoginService(FuncionarioDAO funcionarioRepository) {
        this.FuncionarioDAO = funcionarioRepository;
    }

    public boolean authenticate(String usuario, String senha) {
        Funcionario funcionario = FuncionarioDAO.FindFuncionarioByUser(usuario);
        return funcionario != null && funcionario.getSenha().equals(senha);
    }
}
