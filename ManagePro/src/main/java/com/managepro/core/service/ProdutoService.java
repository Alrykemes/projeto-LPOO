package com.managepro.core.service;

import java.util.List;

import com.managepro.core.model.Produto;
import com.managepro.dao.ProdutoDAO;

/* 
 * ajustar essas excecoes criar ela no pacote e tratalas em codigo,
 * criar validação baseada na UI de estoque e conecta-la deixem todas 
 * as iteraçoes de tela funcionando e testadas obs: testar como usuario 
 * nao precisa criar testes, vamos decidir se deixaremos tudo em 
 * ingles ou portugues no grupo entao por favor siga o padrao
 * e mude o que for preciso para ficar no padrao por favor nao quebre 
 * nenhuma funcionalidade tente mudar apenas o nome das variaveis.
 * apague esse comentario e veja se tem outros pelo commit apaguem 
 * todos os comentarios para evitar conflitos de merging.
 */

public class ProdutoService {

	//private Produto produto;
	private ProdutoDAO produtoDAO;
	
	public ProdutoService() {
		produtoDAO = new ProdutoDAO();
	}

	public Produto getProductById(Long codigoProduto) {
		return produtoDAO.findProductById(codigoProduto);
	}
	
	public void adicionarProduto(Produto produto) {
		validacao(produto);
		produtoDAO.newProduct(produto);
	}

	public List<Produto> listarProdutos() {
		return null;
	}

	public void removerProduto(Long codigoProduto) {
		produtoDAO.removerProduto(codigoProduto);
	}

	public void atualizarProduto(Produto produto) {
		validacao(produto);
		produtoDAO.editarProduto(produto);	
	}


	public void validacao(Produto produto) {

	}
}