package com.managepro.core.service;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.managepro.core.model.Estatistica;
import com.managepro.dao.EstatisticaDAO;
import com.managepro.exceptions.ExcecaoDeNegocios;
import com.managepro.exceptions.ExcecaoDoSistema;



	public class EstatisticaService {
		
		private EstatisticaDAO estatisticaDAO;
		
		public EstatisticaService() throws ClassNotFoundException, SQLException, ExcecaoDoSistema {
			estatisticaDAO = new EstatisticaDAO();
		}
		
		
		
		public Estatistica getEstatisticaById(Long id) throws SQLException, ExcecaoDoSistema, ClassNotFoundException {
			if (id == null || id < 0) {
				throw new IllegalArgumentException("ID inválido.");
			}
				return estatisticaDAO.read(id);
			
		}
		
		
		
		public List<Estatistica> getAllEstatisticas() throws SQLException, ExcecaoDoSistema, ClassNotFoundException {
			return estatisticaDAO.listAll();
		}
		
		
		
		public List<Estatistica> getByQuantidadeVendas(Long quantidadeVenda) throws SQLException, ExcecaoDoSistema, ClassNotFoundException {
			if (quantidadeVenda == 0 || quantidadeVenda < 0) {
				throw new IllegalArgumentException("Não foram realizadas vendas.");
			}
			
			return estatisticaDAO.findByQuantidadeVenda(quantidadeVenda);
		}
		
		
		
		public List<Estatistica> getByQuantidadeFuncionario(Long quantidadeFuncionario) throws SQLException, ExcecaoDoSistema, ClassNotFoundException {
			if (quantidadeFuncionario == 0 || quantidadeFuncionario < 0) { 
				throw new IllegalArgumentException("Não há funcionários cadastrados.");
			}
			
			return estatisticaDAO.findByQuantidadeFuncionario(quantidadeFuncionario);
		}
		
		
		
		public List<Estatistica> getByTotalGanho(BigDecimal precoTotal) throws SQLException, ExcecaoDoSistema, ClassNotFoundException {
			if (precoTotal == null || precoTotal.compareTo(BigDecimal.ZERO) < 0) {
				throw new IllegalArgumentException("Preço inválido.");

			}
			
			return estatisticaDAO.findByTotalGanho(precoTotal);
		}
		
		
		
		public Estatistica getEstatistica() throws SQLException, ExcecaoDoSistema, ExcecaoDeNegocios {
			if (estatisticaDAO.obterEstatisticas() != null) {
				return estatisticaDAO.obterEstatisticas();				
			} else {
				throw new ExcecaoDeNegocios("Nenhum dado a ser mostrado");
			}
		}
		
		
		
		public List<Estatistica> findByData(Date dataInicio, Date dataFim) throws SQLException, ExcecaoDoSistema, ExcecaoDeNegocios, ClassNotFoundException {
	        if(!estatisticaDAO.findByData(dataInicio, dataFim).isEmpty() ) {
	        	return estatisticaDAO.findByData(dataInicio, dataFim);	        	
	        } else {
	        	throw new ExcecaoDeNegocios("Nenhum dado encontrado para o período especificado.");
	        }
	    
		}
		
		
		
		
	}
