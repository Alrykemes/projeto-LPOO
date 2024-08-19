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
	
	/*
	 * ajustar essas excecoes criar ela no pacote e tratalas em codigo,
	 * criar validação baseada na UI de gerenciamento de login e novaVenda e conecta-la deixem todas 
	 * as iteraçoes de tela funcionando e testadas obs: testar como usuario 
	 * nao precisa criar testes, vamos decidir se deixaremos tudo em 
	 * ingles ou portugues no grupo entao por favor siga o padrao
	 * e mude o que for preciso para ficar no padrao por favor nao quebre 
	 * nenhuma funcionalidade tente mudar apenas o nome das variaveis.
	 * apague esse comentario e veja se tem outros pelo commit apaguem 
	 * todos os comentarios para evitar conflitos de merging. 
	 */
	
	public void cadastrarVenda(Venda venda) {
		/*
		 * necessita de verificação de situacao de pagamento apos implementar lib de pagamento.
		 * esse comentario nao precisa apagar! 
		 */
		if(venda != null) {
			if(situacaoPagamento == true) {
				vendaDAO.cadastrarVenda(venda);
			} else {
				
			}
		} else {
			JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), "teste");
		}
	}
}
