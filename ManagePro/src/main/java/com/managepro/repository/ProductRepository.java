package com.managepro.repository;

import java.sql.SQLException;
import java.util.List;

import com.managepro.core.model.Produto;

public interface ProductRepository {

	public void newProduct(Produto produto) throws ClassNotFoundException, SQLException;
	
	public Produto editarProduto (Produto produto) throws ClassNotFoundException, SQLException;
	
	public void removerProduto (Long id_produto) throws ClassNotFoundException, SQLException;
	
	public List<Produto> pesquisarProdutoNome (String nomeProduto) throws ClassNotFoundException, SQLException;
}
