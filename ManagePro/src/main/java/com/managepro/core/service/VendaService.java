package com.managepro.core.service;

import javax.swing.JOptionPane;

import com.managepro.core.model.Cliente;
import com.managepro.dao.ClienteDAO;
import com.managepro.ui.Janela;

public class VendaService {
	
	private ClienteDAO clienteDao;
	
	//private LoginService loginService;
	
	public VendaService() {
		clienteDao = new ClienteDAO();
	}
	
	public Cliente getClientCpf(String cpf) {
		
		if(cpf.replaceAll(" ", "").length() != 14) {
			JOptionPane.showMessageDialog(Janela.getInstace().getPanelPrincipal(), "Número de CPF Invalido!");
			return null;
		}
		return clienteDao.findClientByCpf(cpf);
	}


}
