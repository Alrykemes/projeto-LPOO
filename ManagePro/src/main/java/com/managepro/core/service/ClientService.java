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
	
	public void cadastrarCliente(Cliente cliente) throws Exception {
		if (cliente.getNome().length() >= 69) {
			throw new Exception("Erro, nome muito grande");
		}

		if (dataAtual.compareTo(cliente.getDataNascimento()) < 18) {
			System.out.println(cliente.getDataNascimento().compareTo(dataAtual));
			throw new Exception("Erro, Cliente menor de idade");
		}
		
		if (clienteDAO.findClientByCpf(cliente.getCpf()) != null) {
			clienteDAO.addCliente(cliente);
			Janela.getInstance().getTelaNovaVenda().setCliente(cliente);
			Janela.getInstance().getTelaNovaVenda().setClienteNaTela();
		} else {
			JOptionPane.showMessageDialog(Janela.getInstance().getFrame(), "CPF já cadastrado)");
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
