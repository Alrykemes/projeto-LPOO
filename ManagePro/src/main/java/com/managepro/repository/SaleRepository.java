package com.managepro.repository;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.managepro.core.model.Venda;

public interface SaleRepository {
	
	public void adicionarVendas(Venda venda) throws ClassNotFoundException, SQLException;
	
	public void pesquisarVendasPorId(Long Id) throws ClassNotFoundException, SQLException;
	
	public void deletarVendas(Long Id) throws ClassNotFoundException, SQLException;
	
	public List<Venda> listarVendaPorId(Long Id) throws ClassNotFoundException, SQLException;
	
	public List<Venda> listarVendaPorFuncionario(Long idFuncionario) throws ClassNotFoundException, SQLException;
	
	public List<Venda> listarVendasPorData(LocalDate dataVenda) throws ClassNotFoundException, SQLException;
}
