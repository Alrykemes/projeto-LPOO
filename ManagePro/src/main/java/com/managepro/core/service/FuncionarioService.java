package com.managepro.core.service;

import java.math.BigDecimal;
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
				JOptionPane.showMessageDialog(Janela.getInstance().getFrame(), "Funcionário cadastrado com sucesso!");
			}
		} else {
			throw new Exception("Erro");
		}
	}

	public boolean validarCampos(Funcionario funcionario) throws Exception {
		if (funcionario.getNome().length() <= 4 || funcionario.getNome().length() >= 69) {
			JOptionPane.showMessageDialog(Janela.getInstance().getFrame(), "O nome inserido não é válido");
			return false;
		}

		if (funcionario.getCpf().length() != 14) {
			JOptionPane.showMessageDialog(Janela.getInstance().getFrame(), "CPF inválido");
			return false;
		}

		try {
			BigDecimal salario = funcionario.getSalario();
			if (salario == null || salario.compareTo(BigDecimal.ZERO) <= 0) {
				JOptionPane.showMessageDialog(Janela.getInstance().getFrame(),
						"Salário inválido, deve ser um número positivo");
				return false;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(Janela.getInstance().getFrame(),
					"Salário inválido, deve conter apenas números");
			return false;
		}

		if (funcionario.getUsuario().length() < 4) {
			JOptionPane.showMessageDialog(Janela.getInstance().getFrame(),
					"Nome de usuário muito curto, adicione mais caracteres");
			return false;
		} else if (funcionario.getUsuario().length() > 20) {
			JOptionPane.showMessageDialog(Janela.getInstance().getFrame(), "Nome de usuário muito extenso - MAX(20)");
			return false;
		}

		if (funcionario.getSenha().length() < 4) {
			JOptionPane.showMessageDialog(Janela.getInstance().getFrame(),
					"Senha muito curta, adicione mais caracteres");
			return false;
		} else if (funcionario.getSenha().length() > 20) {
			JOptionPane.showMessageDialog(Janela.getInstance().getFrame(), "Senha muito extensa - MAX(20(");
			return false;
		}

		return true;
	}

	public void criarFuncionario(Funcionario funcionario, String cpfOriginal) throws Exception {
		if (validarCampos(funcionario)) {
			Funcionario funcionarioRetornoBanco = funcionarioDAO.encontrarFuncionarioPeloCpf(cpfOriginal);
			if (funcionarioRetornoBanco != null) {
				FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
				funcionarioDAO.editarFuncionario(funcionario, funcionarioRetornoBanco);
				JOptionPane.showMessageDialog(Janela.getInstance().getFrame(), "Funcionário editado com sucesso!");
			} else {
				JOptionPane.showMessageDialog(Janela.getInstance().getFrame(),
						"Erro ao editar funcionário, funcionário não encontrado", "Erro", JOptionPane.WARNING_MESSAGE);

			}
		}
	}

	public List<Funcionario> obterTodosFuncionarios() {
		return funcionarioDAO.listaDeFuncionarios();
	}
}
