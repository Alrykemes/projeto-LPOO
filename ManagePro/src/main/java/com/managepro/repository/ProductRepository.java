package com.managepro.repository;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.managepro.core.model.Produto;
import com.managepro.core.model.ProdutoVendaDetails;

public interface ProductRepository {

	public Produto findProductById(Long id) throws ClassNotFoundException, SQLException;
	
	public void newProduct(Produto produto) throws ClassNotFoundException, SQLException;
	
	public Produto editarProduto (Produto produto) throws ClassNotFoundException, SQLException;
	
	public void removerProduto (Long id_produto) throws ClassNotFoundException, SQLException;
	
	public List<Produto> pesquisarProdutoNome (String nomeProduto) throws ClassNotFoundException, SQLException;
	
	public List<ProdutoVendaDetails> getProductsForSale(Long idVenda) throws ClassNotFoundException, SQLException;
	
	public List<Produto> getTodosProdutos() throws ClassNotFoundException, SQLException;
	
	public List<Produto> pesquisarProdutoValidade(LocalDate validade) throws ClassNotFoundException, SQLException;

}