package com.managepro.core.service;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import com.managepro.core.model.Estatistica;
import com.managepro.dao.EstatisticaDAO;
import com.managepro.repository.MySQLConnection;
import com.managepro.ui.Janela;



	public class EstatisticaService {
		
		private EstatisticaDAO estatisticaDAO;
		
		
		
		public EstatisticaService() throws ClassNotFoundException, SQLException {
			Connection connection = MySQLConnection.getConnection();
			estatisticaDAO = new EstatisticaDAO(connection);
		}
		
		
		
		public Estatistica getEstatisticaById(Long id) throws SQLException {
			if (id == null || id < 0) {
				throw new IllegalArgumentException("ID inválido.");
			}
			return estatisticaDAO.read(id);
		}
		
		
		
		public List<Estatistica> getAllEstatisticas() throws SQLException {
			return estatisticaDAO.listAll();
		}
		
		
		
		public List<Estatistica> getByQuantidadeVendas(Long quantidadeVenda) throws SQLException {
			if (quantidadeVenda == 0 || quantidadeVenda < 0) {
				throw new IllegalArgumentException("Não foram realizadas vendas.");
			}
			
			return estatisticaDAO.findByQuantidadeVenda(quantidadeVenda);
		}
		
		
		
		public List<Estatistica> getByQuantidadeFuncionario(Long quantidadeFuncionario) throws SQLException {
			if (quantidadeFuncionario == 0 || quantidadeFuncionario < 0) { 
				throw new IllegalArgumentException("Não há funcionários cadastrados.");
			}
			
			return estatisticaDAO.findByQuantidadeFuncionario(quantidadeFuncionario);
		}
		
		
		
		public List<Estatistica> getByTotalGanho(BigDecimal precoTotal) throws SQLException {
			if (precoTotal == null || precoTotal.compareTo(BigDecimal.ZERO) < 0) {
				throw new IllegalArgumentException("Preço inválido.");

			}
			
			return estatisticaDAO.findByTotalGanho(precoTotal);
		}
		
		
		
		public Estatistica getEstatistica() throws SQLException {
			return estatisticaDAO.obterEstatisticas();
		}
		
		
		
		
	}

