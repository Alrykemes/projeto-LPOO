package com.managepro.core.service;

import java.time.LocalDate;
import com.managepro.core.model.Cliente;
import com.managepro.dao.ClienteDAO;
import com.managepro.exceptions.ExcecaoDoSistema;
import com.managepro.exceptions.ValidacaoException;
import com.managepro.ui.Janela;

public class ClientService {
	
	private ClienteDAO clienteDAO;

	LocalDate dataAtual = LocalDate.now();
	
	public ClientService() {
		clienteDAO = new ClienteDAO();
	}
	
	public void cadastrarCliente(Cliente cliente) throws ValidacaoException, ExcecaoDoSistema {
		if (cliente.getNome().length() >= 69) {
			throw new ValidacaoException("Erro, nome muito grande");
		}

		if (dataAtual.compareTo(cliente.getDataNascimento()) < 18) {
			System.out.println(cliente.getDataNascimento().compareTo(dataAtual));
			throw new ValidacaoException("Erro, Cliente menor de idade");
		}
		
		if (clienteDAO.findClientByCpf(cliente.getCpf()) != null) {
			clienteDAO.addCliente(cliente);
			Janela.getInstance().getTelaNovaVenda().setCliente(getClientCpf(cliente.getCpf()));
			Janela.getInstance().getTelaNovaVenda().setClienteNaTela();
		} else {
			throw new ValidacaoException("Já existe um cadastro com esse cpf no sistema!");
		}
	}
	
	public Cliente getClientCpf(String cpf) throws ValidacaoException, ExcecaoDoSistema {
		
		if(cpf.replaceAll(" ", "").length() != 14) {
			throw new ValidacaoException("Cpf invalido!");
		}
		return clienteDAO.findClientByCpf(cpf);
	}
}
