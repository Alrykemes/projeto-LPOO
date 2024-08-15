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
	
	public void CadastrarCliente(String nome, String cpf, LocalDate data_nascimento, String telefone) throws Exception {
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
			JOptionPane.showMessageDialog(Janela.getInstace().getFrame(), "CPF já¡ cadastrado)");
		}
	}
}
