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
		
		if(cpf.length() != 14) {
			JOptionPane.showMessageDialog(Janela.getInstace().getFrame(), "O numero do cpf precisa estar no seguinte formato: xxx.xxx.xxx-xx !");
		}
		
		return clienteDao.findClientByCpf(cpf);
	}


}
