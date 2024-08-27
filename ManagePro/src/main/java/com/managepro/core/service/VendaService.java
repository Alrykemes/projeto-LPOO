package com.managepro.core.service;

import java.time.LocalDate;
import java.util.List;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

import com.managepro.core.model.FormaPagamento;
import com.managepro.core.model.Venda;
import com.managepro.dao.VendaDAO;
import com.managepro.exceptions.ExcecaoDeNegocios;
import com.managepro.exceptions.ExcecaoDoSistema;
import com.managepro.exceptions.ValidacaoException;
import com.managepro.ui.Janela;

public class VendaService {
	
	private VendaDAO vendaDAO;
	private Boolean situacaoPagamento = false;
	
	public VendaService() {
		vendaDAO = new VendaDAO();
	}
	
	public void cadastrarVenda(Venda venda) throws ExcecaoDeNegocios, ValidacaoException, ExcecaoDoSistema {
		
		if(venda != null) {	
			validarVenda(venda);
				
			if (venda.getFormaDePagamentoEnum().equals(FormaPagamento.DINHEIRO)) {
					if(venda.getValorRecebido() == null) {
						throw new ExcecaoDeNegocios("Você precisa definir um valor a ser recebido!");
					}
					if(venda.getValorRecebido().compareTo(venda.getPreco()) < 0) {
						throw new ExcecaoDeNegocios("O valor Recebido não pode ser menor que o preço dos produtos!");
					} else {
						situacaoPagamento = true;
					}
			}
			
			if (venda.getFormaDePagamentoEnum().equals(FormaPagamento.PIX)) { }
			
			if (venda.getFormaDePagamentoEnum().equals(FormaPagamento.CARTAODEDEBITO)) {}
			
			if (venda.getFormaDePagamentoEnum().equals(FormaPagamento.CARTAODEDEBITO)) {}
			
			if(situacaoPagamento == true) {	
				vendaDAO.cadastrarVenda(venda);
			} else {
				throw new ExcecaoDeNegocios("Pagamento não aprovado");
			}
		} else {
				JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), "Reporte o Erro Venda é Null");
		}
	}
	
	public List<Venda> getTodasVendas() throws ExcecaoDoSistema, ExcecaoDeNegocios {
		try {
			if(vendaDAO.listarTodasAsVendas() != null) {
				return vendaDAO.listarTodasAsVendas();
			} else {
				throw new ExcecaoDeNegocios("Não há vendas Realizadas até o momento!");
			}
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<Venda> getVendasPorFuncionarioId(Long id) throws ExcecaoDoSistema, ExcecaoDeNegocios {
		if(vendaDAO.listarVendasPorIdFuncionario(id).isEmpty()) {
			throw new ExcecaoDeNegocios("Não há vendas realizadas por esse funcionário no sistema!");
		} else {				
			return vendaDAO.listarVendasPorIdFuncionario(id);					
		}
	}
	
	public List<Venda> getVendasPorId(Long id) throws ExcecaoDoSistema, ExcecaoDeNegocios {
		if(vendaDAO.pesquisarVendaPorId(id).isEmpty()) {
			throw new ExcecaoDeNegocios("Não há vendas realizadas com esse ID.");			
		} else {
			return vendaDAO.pesquisarVendaPorId(id);					
		}
	} 
	
	public List<Venda> getVendasPorIntervaloDeDatas(LocalDate de, LocalDate ate) throws ExcecaoDoSistema, ExcecaoDeNegocios {
		if(vendaDAO.listarVendasPorIntervaloDeData(de, ate).isEmpty()) {
			throw new ExcecaoDeNegocios("Não há vendas realizadas entre esse intervalo de datas até o momento.");			
		} else {
			return vendaDAO.listarVendasPorIntervaloDeData(de, ate);				
		}
	}
	
	public void deletarVendaPorId(Long id) throws ExcecaoDoSistema, ExcecaoDeNegocios {
		if (vendaDAO.pesquisarVendaPorId(id) != null) {
			vendaDAO.deletarVenda(id);
		} else {
			throw new ExcecaoDeNegocios("Venda não encontrada no sistema!");
		}
	}
	
	public boolean validarIdEQtdDoProduto(JFormattedTextField codField, JFormattedTextField qtdField) throws ExcecaoDoSistema, ExcecaoDeNegocios {
		if(codField.getText().replaceAll(" ", "").length() <= 0) {
			throw new ExcecaoDeNegocios("Insira o código do produto desejado.");
		} else {
			if(qtdField.getText().replaceAll(" ", "").length() <= 0) {
				throw new ExcecaoDeNegocios("Insira a quantidade desejada do produto");
			} else {
				return true;
			}
		}
	}
	
	public void validarVenda(Venda venda) throws ValidacaoException, ExcecaoDeNegocios {
		
		if(venda.getData() == null) {
			throw new ValidacaoException("Data da Compra é null");
		}
		
		if(venda.getProdutosVendidos() == null) {
			throw new ValidacaoException("A lista de produtos da compra é null");
		}
		
		if(venda.getCliente() == null) {
			throw new ExcecaoDeNegocios("A venda deve ter um cliente!");
		}
	}
}
