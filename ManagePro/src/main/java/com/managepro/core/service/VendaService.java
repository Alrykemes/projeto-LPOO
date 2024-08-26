package com.managepro.core.service;



import java.security.InvalidParameterException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JFormattedTextField;
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
		/*
		 * necessita de verifica��o de situacao de pagamento apos implementar lib de pagamento.
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
				JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), "Reporte o Erro Venda � Null");
		}
	}
	
	public List<Venda> getTodasVendas() {
		
			try {
				if(vendaDAO.listarTodasAsVendas() != null) {
					return vendaDAO.listarTodasAsVendas();					
				}
				JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), "Nenhuma Venda realizada at� o momento");
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
						"N�o h� vendas realizadas por esse funcion�rio ou o mesmo n�o existe.");
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
				JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), "N�o h� vendas com esse ID.");				
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
						"N�o h� vendas entre esse intervalo de datas.");				
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
				JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), "Venda n�o encontrada!");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean validarIdEQtdDoProduto(JFormattedTextField codField, JFormattedTextField qtdField) {
		
		if(codField.getText().replaceAll(" ", "").length() <= 0) {
			JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), "Insira o código do produto desejado");
			return false;
		} else {
			if(qtdField.getText().replaceAll(" ", "").length() <= 0) {
				JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), "Insira a quantidade desejada do produto");
				return false;
			} else {
				return true;
			}
		}
	}
	
	public boolean validarValorRecebido(JFormattedTextField valorInseridoField) {
		// logica de validacao
		return false;
	}
	
	public void validarVenda(Venda venda) throws Exception {
		
		if(venda.getData() == null) {
			JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), "Reporte o Erro Data � Null");
			throw new InvalidParameterException("Data da Compra � null", null);
		}
		
		if(venda.getProdutosVendidos() == null) {
			JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), "Reporte o Erro Produtos � Null");
			throw new InvalidParameterException("A lista de produtos da Compra s�o null", null);
		}
	}
}
