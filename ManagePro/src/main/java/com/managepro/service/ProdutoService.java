package com.managepro.service;

import java.util.List;

public class ProdutoService {
	
	private Produto produto;
	
	public void adicionarProduto(Produto produto) throws ValicadaoException {
		validacao(produto);
		ProdutoRepository.salvar(produto);
	}
	
	public List<Produto> listarProdutos() {
		return ProdutoRepository.listarDados();
	}
	
	public void removerProduto(Long codigoProduto, Produto produto) throws ValicadaoException {
		validacao(produto);
		ProdutoRepository.remover(codigoProduto);
	}
	
	public void atualizarProduto(Produto produto) throws ValicadaoException {
		validacao(produto);
		ProdutoRepository.atualizar(produto);	
	}
	
	public produto buscarProduto(Long codigoProduto) throws ValicadaoException {
		
		Produto produto = ProdutoRepository.buscar(codigoProduto);
		
		return produto;
		
		
	}
	
	public void validacao(Produto produto) {
		
	// exceções buscar produto
		
		if (produto == null) {
			throw new ValidacaoException("Produto não existe.");
		}
		
		// exceções gerais do produto
		
		if (produto.getnomeProduto() == null);
		throw new ValidacaoException("Nome do produto é obrigatório");
		
		if (produto.getCodigoProduto == null) {
			throw new ValidacaoException("Codigo do produto é obrigatório.");
		}
		
		if (produto.getMarcaProduto == null) {
			throw new ValidacaoException("Marca é obrigatória.");
		}
		
		if (produto.getPreco == null) {
			throw new ValidacaoException("Preço é obrigatório.");
		}
		
		if (produto.getPreco < 0 || produto.getPreco == null) {
			throw new ValidacaoException("Preço não pode ser negativo e/ou é obrigatório.");
		}
		
	}
}
