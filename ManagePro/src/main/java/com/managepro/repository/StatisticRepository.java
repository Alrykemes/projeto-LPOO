package com.managepro.repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.managepro.core.model.Estatistica;
import com.toedter.calendar.JDateChooser;

public interface StatisticRepository {
	
	public Estatistica read(Long id) throws SQLException;
	
	public List<Estatistica> listAll() throws SQLException;
	
	public List<Estatistica> findByQuantidadeVenda(Long quantidadeVenda) throws SQLException;
	
	public List<Estatistica> findByQuantidadeFuncionario(Long quantidadeFuncionario) throws SQLException;
	
	public List<Estatistica> findByPrecoTotal(BigDecimal precoTotal) throws SQLException;
	
	public List<Object[]> getQuantidadeVendasPorCategoria(JDateChooser dateChooserInicial, JDateChooser dateChooserFinal) throws SQLException;
	 
	public Estatistica obterEstatisticas(Date dataInicial, Date dataFinal) throws SQLException;
}
