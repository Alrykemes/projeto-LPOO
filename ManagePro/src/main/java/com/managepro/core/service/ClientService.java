package com.managepro.core.service;

import java.time.LocalDate;
import javax.swing.JOptionPane;
import com.managepro.core.model.Cliente;
import com.managepro.dao.ClienteDAO;
import com.managepro.ui.Janela;

public class ClientService {
	
	private ClienteDAO clienteDAO;

	LocalDate dataAtual = LocalDate.now();
	
	public ClientService() {
		clienteDAO = new ClienteDAO();
	}
	
	public void cadastrarCliente(String nome, String cpf, String telefone, LocalDate data_nascimento) throws Exception {
		if (nome.length() >= 69) {
			throw new Exception("Erro, nome muito grande");
		}

		if (dataAtual.compareTo(data_nascimento) < 18) {
			System.out.println(data_nascimento.compareTo(dataAtual));
			throw new Exception("Erro, Cliente menor de idade");
		}
		
		if (clienteDAO.findClientByCpf(cpf) != null) {
			Cliente cliente = new Cliente(nome, cpf, telefone, data_nascimento);
			clienteDAO.addCliente(cliente);
		} else {
			JOptionPane.showMessageDialog(Janela.getInstance().getFrame(), "CPF já¡ cadastrado)");
		}
	}
	
	public Cliente getClientCpf(String cpf) {
		
		if(cpf.replaceAll(" ", "").length() != 14) {
			JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), "Número de CPF Invalido!");
			return null;
		}
		return clienteDAO.findClientByCpf(cpf);
	}
}
