package com.managepro.core.service;

import javax.swing.JOptionPane;

import com.managepro.core.model.Funcionario;
import com.managepro.dao.ClienteDAO;
import com.managepro.dao.FuncionarioDAO;
import com.managepro.ui.Janela;

public class FuncionarioService {
	/* 
	 * criar excecoes no pacote certo e tratalas em codigo,
	 * criar valida��o baseada na UI de funcionarios e conecta-la deixem todas 
	 * as itera�oes de tela funcionando e testadas obs: testar como usuario 
	 * nao precisa criar testes, vamos decidir se deixaremos tudo em 
	 * ingles ou portugues no grupo entao por favor siga o padrao
	 * e mude o que for preciso para ficar no padrao por favor nao quebre 
	 * nenhuma funcionalidade tente mudar apenas o nome das variaveis.
	 * apague esse comentario e veja se tem outros pelo commit apaguem 
	 * todos os comentarios para evitar conflitos de merging.
	 * 
	 * refazer funcionario service no mesmo padrao dos outros services criados
	 * validem dados no service e passem para o bd, puxem dados do bd pelo service 
	 * para depois mandar para UI.
	 */
	private FuncionarioDAO funcionarioDAO;
	
	public FuncionarioService() {
		funcionarioDAO = new FuncionarioDAO();
	}
	
	public void criarFuncionario(Funcionario funcionario) throws Exception {
		if (validarCampos(funcionario)) {
			if (funcionarioDAO.encontrarFuncionarioPeloCpf(funcionario.getCpf()) != null) {
				JOptionPane.showMessageDialog(Janela.getInstance().getFrame(), "Funcionário já cadastrado)");
			} else {
				funcionarioDAO.adicionarFuncionario(funcionario);
				JOptionPane.showMessageDialog(Janela.getInstance().getFrame(), "Funcionário cadastrado)");
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
}
