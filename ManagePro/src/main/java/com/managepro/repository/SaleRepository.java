package com.managepro.repository;

import java.time.LocalDate;
import java.util.List;
import com.managepro.core.model.Venda;
import com.managepro.exceptions.ExcecaoDoSistema;

public interface SaleRepository {
	
	public void cadastrarVenda(Venda venda) throws ExcecaoDoSistema;
	
	public void deletarVenda(Long Id) throws ExcecaoDoSistema;

	public List<Venda> listarTodasAsVendas() throws ExcecaoDoSistema;
	
	public List<Venda> pesquisarVendaPorId(Long Id) throws ExcecaoDoSistema;
	
	public List<Venda> listarVendasPorIdFuncionario(Long idFuncionario) throws ExcecaoDoSistema;
	
	public List<Venda> listarVendasPorIntervaloDeData(LocalDate de, LocalDate ate) throws ExcecaoDoSistema;
}
