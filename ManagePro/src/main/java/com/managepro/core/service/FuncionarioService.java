package com.managepro.core.service;

import java.math.BigDecimal;

import java.util.List;

import com.managepro.core.model.Funcionario;
import com.managepro.dao.FuncionarioDAO;
import com.managepro.exceptions.ValidacaoException;
import com.managepro.exceptions.ExcecaoDeNegocios;
import com.managepro.exceptions.ExcecaoDoSistema;

public class FuncionarioService {

	private FuncionarioDAO funcionarioDAO;

	public FuncionarioService() {
		funcionarioDAO = new FuncionarioDAO();
	}

	public void criarFuncionario(Funcionario funcionario) throws ExcecaoDeNegocios, ExcecaoDoSistema {
		try {
			if (validarCampos(funcionario)) {
				if (funcionarioDAO.encontrarFuncionarioPeloCpf(funcionario.getCpf()) != null) {
					throw new ExcecaoDoSistema("Funcionário já cadastrado com o CPF: " + funcionario.getCpf());
				} else {
					funcionarioDAO.adicionarFuncionario(funcionario);
				}
			} else {
				throw new ExcecaoDeNegocios("Erro ao validar os dados do funcion�rio.");
			}
		} catch (Exception e) {
			throw new ExcecaoDoSistema("Erro ao criar funcionário: " + e.getMessage(), e);
		}
	}

	public boolean validarCampos(Funcionario funcionario) throws ValidacaoException {
		if (funcionario.getNome().length() <= 4 || funcionario.getNome().length() >= 69) {
			throw new ValidacaoException("O nome inserido n�o � v�lido. Deve ter entre 5 e 68 caracteres.");
		}

		if (funcionario.getCpf().length() != 14) {
			throw new ValidacaoException("CPF inv�lido. Deve conter 14 caracteres.");
		}

		try {
			BigDecimal salario = funcionario.getSalario();
			if (salario == null || salario.compareTo(BigDecimal.ZERO) <= 0) {
				throw new ValidacaoException("Sal�rio inv�lido. Deve ser um n�mero positivo.");
			}
		} catch (NumberFormatException e) {
			throw new ValidacaoException("Sal�rio inv�lido. Deve conter apenas n�meros.");
		}

		if (funcionario.getUsuario().length() < 4) {
			throw new ValidacaoException("Nome de usu�rio muito curto. Deve ter pelo menos 4 caracteres.");
		} else if (funcionario.getUsuario().length() > 20) {
			throw new ValidacaoException("Nome de usu�rio muito extenso. M�ximo de 20 caracteres.");
		}

		if (funcionario.getSenha().length() < 4) {
			throw new ValidacaoException("Senha muito curta. Deve ter pelo menos 4 caracteres.");
		} else if (funcionario.getSenha().length() > 20) {
			throw new ValidacaoException("Senha muito extensa. M�ximo de 20 caracteres.");
		}
		return true;
	}

	public boolean editarFuncionario(Funcionario funcionario, String cpfOriginal) throws ExcecaoDoSistema, ExcecaoDeNegocios {
		try {
			if (validarCampos(funcionario)) {
				Funcionario funcionarioRetornoBanco = funcionarioDAO.encontrarFuncionarioPeloCpf(cpfOriginal);
				if (funcionarioRetornoBanco != null) {
					funcionarioDAO.editarFuncionario(funcionario, funcionarioRetornoBanco);
					return true;
				} else {
					throw new ExcecaoDoSistema(
							"Erro ao editar funcion�rio: Funcion�rio n�o encontrado com o CPF: " + cpfOriginal);
				}
			}
		} catch (Exception e) {
			throw new ExcecaoDeNegocios("Erro ao editar funcion�rio: " + e.getMessage(), e);
		}
		return false;
	}

	public boolean apagarFuncionario(String cpf) throws ExcecaoDoSistema, ExcecaoDeNegocios {
		try {
			Funcionario funcionarioRetornoBanco = funcionarioDAO.encontrarFuncionarioPeloCpf(cpf);
			if (funcionarioRetornoBanco != null) {
				funcionarioDAO.removerFuncionario(funcionarioRetornoBanco.getId());
				return true;
			} else {
				throw new ExcecaoDoSistema("Erro ao remover funcion�rio: Funcion�rio n�o encontrado com o CPF: " + cpf);
			}
		} catch (Exception e) {
			throw new ExcecaoDeNegocios("Erro ao remover funcion�rio: " + e.getMessage(), e);
        }
	}

	public List<Funcionario> obterTodosFuncionarios() throws ExcecaoDoSistema {
		try {
			return funcionarioDAO.listaDeFuncionarios();
		} catch (Exception e) {
			throw new ExcecaoDoSistema("Erro ao obter lista de funcion�rios: " + e.getMessage(), e);
		}
	}
}