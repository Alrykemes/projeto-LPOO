package com.managepro.core.service;



import javax.swing.JOptionPane;

import com.managepro.core.model.Venda;
import com.managepro.dao.VendaDAO;
import com.managepro.ui.Janela;

public class VendaService {
	
	private VendaDAO vendaDAO;
	private Boolean situacaoPagamento = true;
	
	public VendaService() {
		vendaDAO = new VendaDAO();
	}
	
	public void cadastrarVenda(Venda venda) {
		if(venda != null) {
			if(situacaoPagamento == true) {
				vendaDAO.adicionarVendas(venda);
			} else {
				
			}
		} else {
			JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), "teste");
		}
		
		
	}


}
