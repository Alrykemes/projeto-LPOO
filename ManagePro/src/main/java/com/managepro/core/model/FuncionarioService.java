package com.managepro.core.model;

import com.managepro.core.model.Funcionario;
import com.managepro.core.model.FuncionarioDAO;
import com.managepro.core.service.FuncionarioService;
import java.math.BigDecimal;

public class FuncionarioService {
	private FuncionarioDAO funcionarioDAO;

    public FuncionarioService() {
        this.funcionarioDAO = new FuncionarioDAO();
    }
    
    public List<Funcionario> obterTodosFuncionarios() {
        return funcionarioDAO.getAllFuncionarios();
    }

    public boolean adicionarFuncionario(String nome, String cpf, String email, String cargo, double salario) {
        // Valida os dados
        if (!Validator.validarNome(nome)) {
            System.out.println("Nome inválido");
            return false;
        }
        if (!Validator.validarCPF(cpf)) {
            System.out.println("CPF inválido");
            return false;
        }
        if (!Validator.validarEmail(email)) {
            System.out.println("Email inválido");
            return false;
        }
        if (!Validator.validarCargo(cargo)) {
            System.out.println("Cargo inválido");
            return false;
        }
        if (!Validator.validarSalario(salario)) {
            System.out.println("Salário inválido");
            return false;
        }

        // Se todas as validações passarem, cria o objeto Funcionario
        Funcionario funcionario = new Funcionario(nome, cpf, email, cargo, salario);

        // Chama a DAO para salvar o funcionário no banco de dados
        return funcionarioDAO.inserirFuncionario(funcionario);
    }
}
