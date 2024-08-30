package com.managepro.repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.managepro.core.model.Estatistica;
import com.managepro.exceptions.ExcecaoDoSistema;

public interface StatisticRepository {

	public Estatistica read(Long id) throws ExcecaoDoSistema, SQLException, ClassNotFoundException;

	public List<Estatistica> listAll() throws SQLException, ExcecaoDoSistema, ClassNotFoundException;

    public List<Estatistica> findByQuantidadeVenda(Long quantidadeVenda) throws ExcecaoDoSistema, SQLException, ClassNotFoundException;

    public List<Estatistica> findByQuantidadeFuncionario(Long quantidadeFuncionario) throws ExcecaoDoSistema, SQLException, ClassNotFoundException;

    public List<Estatistica> findByTotalGanho(BigDecimal precoTotal) throws ExcecaoDoSistema, SQLException, ClassNotFoundException;
    
    public Estatistica obterEstatisticas() throws ExcecaoDoSistema, SQLException, ClassNotFoundException;

    public List<Estatistica> findByData(Date dataInicio, Date dataFim) throws ExcecaoDoSistema, SQLException, ClassNotFoundException;
}