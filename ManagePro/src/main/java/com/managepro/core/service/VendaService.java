package com.managepro.core.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JFormattedTextField;

import com.managepro.core.model.FormaPagamento;
import com.managepro.core.model.Venda;
import com.managepro.dao.VendaDAO;
import com.managepro.exceptions.ExcecaoDeNegocios;
import com.managepro.exceptions.ExcecaoDoSistema;
import com.managepro.exceptions.ValidacaoException;

public class VendaService {

	private VendaDAO vendaDAO;
	private Boolean situacaoPagamento = false;

	public VendaService() {
		vendaDAO = new VendaDAO();
	}

	public void cadastrarVenda(Venda venda)
			throws ExcecaoDeNegocios, ValidacaoException, ExcecaoDoSistema, SQLException {

		if (venda != null) {
			validarVenda(venda);

			if (venda.getFormaDePagamentoEnum().equals(FormaPagamento.DINHEIRO)) {
				if (venda.getValorRecebido() == null) {
					throw new ExcecaoDeNegocios("Voc� precisa definir um valor a ser recebido!");
				}
				if (venda.getValorRecebido().compareTo(venda.getPreco()) < 0) {
					throw new ExcecaoDeNegocios("O valor Recebido n�o pode ser menor que o pre�o dos produtos!");
				} else {
					situacaoPagamento = true;
				}
			}

			if (venda.getFormaDePagamentoEnum().equals(FormaPagamento.PIX)) {

			}

			if (venda.getFormaDePagamentoEnum().equals(FormaPagamento.CARTAODEDEBITO)) {
				throw new ExcecaoDeNegocios("Implementa��o de pagamento por cart�es em desenvolvimento.");
			}

			if (venda.getFormaDePagamentoEnum().equals(FormaPagamento.CARTAODECREDITO)) {
				throw new ExcecaoDeNegocios("Implementa��o de pagamento por cart�es em desenvolvimento.");
			}

			if (situacaoPagamento == true) {
				vendaDAO.cadastrarVenda(venda);
			} else {
				throw new ExcecaoDeNegocios("Pagamento n�o aprovado.");
			}
		} else {
			throw new ValidacaoException("Reporte venda � null!");
		}
	}

	public List<Venda> getTodasVendas() throws ExcecaoDoSistema, ExcecaoDeNegocios {
		try {
			if (vendaDAO.listarTodasAsVendas() != null) {
				return vendaDAO.listarTodasAsVendas();
			} else {
				throw new ExcecaoDeNegocios("N�o h� vendas Realizadas at� o momento!");
			}
		} catch (Exception e) {
			return null;
		}
	}

	public List<Venda> getVendasPorFuncionarioId(Long id) throws ExcecaoDoSistema, ExcecaoDeNegocios {
		if (vendaDAO.listarVendasPorIdFuncionario(id).isEmpty()) {
			throw new ExcecaoDeNegocios("N�o h� vendas realizadas por esse funcion�rio no sistema!");
		} else {
			return vendaDAO.listarVendasPorIdFuncionario(id);
		}
	}

	public List<Venda> getVendasPorId(Long id) throws ExcecaoDoSistema, ExcecaoDeNegocios {
		if (vendaDAO.pesquisarVendaPorId(id).isEmpty()) {
			throw new ExcecaoDeNegocios("N�o h� vendas realizadas com esse ID.");
		} else {
			return vendaDAO.pesquisarVendaPorId(id);
		}
	}

	public List<Venda> getVendasPorIntervaloDeDatas(LocalDate de, LocalDate ate)
			throws ExcecaoDoSistema, ExcecaoDeNegocios {
		if (vendaDAO.listarVendasPorIntervaloDeData(de, ate).isEmpty()) {
			throw new ExcecaoDeNegocios("N�o h� vendas realizadas entre esse intervalo de datas at� o momento.");
		} else {
			return vendaDAO.listarVendasPorIntervaloDeData(de, ate);
		}
	}

	public List<Venda> getVendasPorCpfCliente(String cpf) throws ExcecaoDoSistema, ExcecaoDeNegocios {
		return null;

	}

	public void deletarVendaPorId(Long id) throws ExcecaoDoSistema, ExcecaoDeNegocios {
		if (vendaDAO.pesquisarVendaPorId(id) != null) {
			vendaDAO.deletarVenda(id);
		} else {
			throw new ExcecaoDeNegocios("Venda n�o encontrada no sistema!");
		}
	}

	public boolean validarIdEQtdDoProduto(JFormattedTextField codField, JFormattedTextField qtdField)
			throws ExcecaoDoSistema, ExcecaoDeNegocios {
		if (codField.getText().replaceAll(" ", "").length() <= 0) {
			throw new ExcecaoDeNegocios("Insira o c�digo do produto desejado.");
		} else {
			if (qtdField.getText().replaceAll(" ", "").length() <= 0) {
				throw new ExcecaoDeNegocios("Insira a quantidade desejada do produto");
			} else {
				return true;
			}
		}
	}

	public void gerarAnaliseDiaria() throws SQLException, ExcecaoDoSistema {
		vendaDAO.gerarRelatorioDiario();
	}

	public void validarPix(boolean confirmacaoPix) {
		this.situacaoPagamento = confirmacaoPix;
	}

	public void validarVenda(Venda venda) throws ValidacaoException, ExcecaoDeNegocios {

		if (venda.getCliente() == null) {
			throw new ExcecaoDeNegocios("A venda deve ter um cliente!");
		}

		if (venda.getProdutosVendidos() == null) {
			throw new ValidacaoException("A venda deve ter Produtos");
		}

		if (venda.getData() == null) {
			throw new ValidacaoException("Data da Compra � null");
		}
	}
}