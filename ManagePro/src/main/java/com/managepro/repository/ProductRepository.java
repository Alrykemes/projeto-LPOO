package com.managepro.repository;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.managepro.core.model.Produto;
import com.managepro.core.model.ProdutoVendaDetails;
import com.managepro.exceptions.ExcecaoDoSistema;

public interface ProductRepository {

	public Produto findProductById(Long id) throws ClassNotFoundException, SQLException, ExcecaoDoSistema;
	
	public void newProduct(Produto produto) throws ClassNotFoundException, SQLException, ExcecaoDoSistema;
	
	public Produto editarProduto (Produto produto) throws ClassNotFoundException, SQLException, ExcecaoDoSistema;
	
	public void removerProduto (Long id_produto) throws ClassNotFoundException, SQLException, ExcecaoDoSistema;
	
	public List<Produto> pesquisarProdutoNome (String nomeProduto) throws ClassNotFoundException, SQLException, ExcecaoDoSistema;
	
	public List<ProdutoVendaDetails> getProductsForSale(Long idVenda) throws ClassNotFoundException, SQLException, ExcecaoDoSistema;
	
	public List<Produto> getTodosProdutos() throws ClassNotFoundException, SQLException, ExcecaoDoSistema;
	
	public List<Produto> pesquisarProdutoValidade(LocalDate validade) throws ClassNotFoundException, SQLException, ExcecaoDoSistema;

}