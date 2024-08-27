package com.managepro.core.service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import com.managepro.core.model.Estatistica;
import com.managepro.dao.EstatisticaDAO;
import com.managepro.ui.Janela;


public class EstatisticaService {
	
	private EstatisticaDAO estatisticaDAO;
	
	public EstatisticaService() {
		estatisticaDAO = new EstatisticaDAO();
	}
	
	public Estatistica getEstatisticaById(Long id) {
		if (id == null || id < 0) {
			JOptionPane.showMessageDialog(Janela.getInstance().getPanelPrincipal(), "Id inválido");
			throw new IllegalArgumentException("ID inválido.");
		}
		return estatisticaDAO.read(id);
	}
	
	public List<Estatistica> getAllEstatisticas() {
		return estatisticaDAO.listAll();
	}
	
	public List<Estatistica> getByQuantidadeVendas(Long quantidadeVenda) {
		if (quantidadeVenda == 0 || quantidadeVenda < 0) {
			throw new IllegalArgumentException("Não foram realizadas vendas.");
		}
		
		return estatisticaDAO.findByQuantidadeVenda(quantidadeVenda);
	}
	
	public List<Estatistica> getByQuantidadeFuncionario(Long quantidadeFuncionario) {
		if (quantidadeFuncionario == 0 || quantidadeFuncionario < 0) { 
			throw new IllegalArgumentException("Não há funcionários cadastrados.");
		}
		
		return estatisticaDAO.findByQuantidadeFuncionario(quantidadeFuncionario);
	}
	
	public List<Estatistica> getByPrecoTotal(BigDecimal precoTotal) {
		if (precoTotal == null || precoTotal < 0) {
			throw new IllegalArgumentException("Preço inválido.");

		}
		
		return estatisticaDAO.findByPrecoTotal(precoTotal);
	}
	
	public Estatistica getEstatistica() {
		return estatisticaDAO.obterEstatisticas();
	}
	
}
