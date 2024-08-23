package com.managepro.repository;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.managepro.core.model.Venda;

public interface SaleRepository {
	
	public void cadastrarVenda(Venda venda) throws ClassNotFoundException, SQLException;
	
	public void deletarVenda(Long Id) throws ClassNotFoundException, SQLException;

	public List<Venda> listarTodasAsVendas() throws ClassNotFoundException, SQLException;
	
	public List<Venda> pesquisarVendaPorId(Long Id) throws ClassNotFoundException, SQLException;
	
	public List<Venda> listarVendasPorIdFuncionario(Long idFuncionario) throws ClassNotFoundException, SQLException;
	
	public List<Venda> listarVendasPorIntervaloDeData(LocalDate de, LocalDate ate) throws ClassNotFoundException, SQLException;
}
