package com.managepro.core.model;

import javax.swing.JOptionPane;

public class FuncionarioUI {
	private FuncionarioService funcionarioService;

    public FuncionarioUI() {
        this.funcionarioService = new FuncionarioService();
    }

    public void salvarFuncionario() {
        // Captura os dados da UI
        String nome = txtNome.getText();
        String cpf = txtCpf.getText();
        String email = txtEmail.getText();
        String cargo = txtCargo.getText();
        double salario = Double.parseDouble(txtSalario.getText());

        // Tenta salvar o funcionário
        boolean sucesso = funcionarioService.adicionarFuncionario(nome, cpf, email, cargo, salario);

        if (sucesso) {
            JOptionPane.showMessageDialog(null, "Funcionário salvo com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao salvar funcionário.");
        }
    }
}
