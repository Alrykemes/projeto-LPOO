package com.managepro.core.service;



import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JOptionPane;

import com.managepro.core.model.FormaPagamento;
import com.managepro.core.model.Venda;
import com.managepro.dao.VendaDAO;
import com.managepro.exceptions.ValidacaoException;
import com.managepro.ui.Janela;

public class VendaService {
	
	private VendaDAO vendaDAO;
	private Boolean situacaoPagamento = true;
	
	public VendaService() {
		vendaDAO = new VendaDAO();
	}
	
	public void cadastrarVenda(Venda venda) {
		/*
		 * necessita de verificação de situacao de pagamento apos implementar lib de pagamento.
		 * esse comentario nao precisa apagar! 
		 */
		if(venda != null) {
			try {
				validarVenda(venda);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(situacaoPagamento == true) {	
				vendaDAO.cadastrarVenda(venda);
			} else {
				//
			}
		} else {
				JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), "Reporte o Erro Venda é Null");
		}
	}
	
	public List<Venda> getTodasVendas() {
		
			try {
				if(vendaDAO.listarTodasAsVendas() != null) {
					return vendaDAO.listarTodasAsVendas();					
				}
				JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), "Nenhuma Venda realizada até o momento");
				return null;
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				return null;
			}
	}
	
	public List<Venda> getVendasPorFuncionarioId(Long id) {
		try {
			if(vendaDAO.listarVendasPorIdFuncionario(id).isEmpty()) {
				JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), 
						"Não há vendas realizadas por esse funcionário ou o mesmo não existe.");
			} else {				
				return vendaDAO.listarVendasPorIdFuncionario(id);					
			}
			return null;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Venda> getVendasPorId(Long id) {
		try {
			if(vendaDAO.pesquisarVendaPorId(id).isEmpty()) {
				JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), "Não há vendas com esse ID.");				
				return null;
			} else {
				return vendaDAO.pesquisarVendaPorId(id);					
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Venda> getVendasPorIntervaloDeDatas(LocalDate de, LocalDate ate) {
		try {
			if(vendaDAO.listarVendasPorIntervaloDeData(de, ate).isEmpty()) {
				JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), 
						"Não há vendas entre esse intervalo de datas.");				
				return null;
			} else {
				return vendaDAO.listarVendasPorIntervaloDeData(de, ate);				
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void deletarVendaPorId(Long id) {
		try {
			if (vendaDAO.pesquisarVendaPorId(id) != null) {
				vendaDAO.deletarVenda(id);
			} else {
				JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), "Venda não encontrada!");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void validarVenda(Venda venda) throws Exception {
		
		if(venda.getData() == null) {
			JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), "Reporte o Erro Data é Null");
			throw new ValidacaoException("Data da Compra é null", null);
		}
		
		if(venda.getProdutosVendidos() == null) {
			JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), "Reporte o Erro Produtos é Null");
			throw new ValidacaoException("A lista de produtos da Compra são null", null);
		}
		
		if (venda.getFormaDePagamentoEnum().equals(FormaPagamento.DINHEIRO)) {
			if(venda.getValorRecebido().compareTo(venda.getPreco()) < 0) {
				JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), "O valor Recebido não pode ser menor que o preço dos produtos!");
				throw new ValidacaoException("O valor recebido é menor que o preço dos produtos.", null);
			}
		}
	}
}
