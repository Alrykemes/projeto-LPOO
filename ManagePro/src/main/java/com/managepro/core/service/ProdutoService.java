package com.managepro.core.service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.managepro.core.model.Produto;
import com.managepro.dao.ProdutoDAO;
import com.managepro.exceptions.ValidacaoException;

/* 
 * ajustar essas excecoes criar ela no pacote e tratalas em codigo,
 * criar valida��o baseada na UI de estoque e conecta-la deixem todas 
 * as itera�oes de tela funcionando e testadas obs: testar como usuario 
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
	
	public void adicionarProduto(Produto produto) throws ValidacaoException {
		validacao(produto);
		produtoDAO.newProduct(produto);
	}
	
	public List<Produto> pesquisarProdutoNome(String nomeProduto){
		return produtoDAO.pesquisarProdutoNome(nomeProduto);
	}
	
	public List<Produto> pesquisarProdutoId(Long id){
		return produtoDAO.pesquisarProdutoID(id);
	}

	public List<Produto> pesquisarProdutoValidade(LocalDate validade) throws ClassNotFoundException, SQLException{
		return produtoDAO.pesquisarProdutoValidade(validade);
	}

	public List<Produto> listarProdutos()  {
		try {
			return produtoDAO.getTodosProdutos();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void removerProduto(Long codigoProduto) {
		produtoDAO.removerProduto(codigoProduto);
	}

	public void atualizarProduto(Produto produto) throws ValidacaoException {
		validacao(produto);
		produtoDAO.editarProduto(produto);	
	}


	public void validacao(Produto produto) throws ValidacaoException {

		// exceções buscar produto

			if (produto == null) {
				throw new ValidacaoException("Produto não existe.");
			}

			// exceções gerais do produto

			if (produto.getNomeProduto() == null) {
			throw new ValidacaoException("Nome do produto é obrigatório");
			}
			
			if (produto.getMarca() == null) {
				throw new ValidacaoException("Marca é obrigatória.");
			}

			if (produto.getPreco() == null) {
				throw new ValidacaoException("Preço é obrigatório.");
			}
			
			BigDecimal zero = new BigDecimal(0);
			int resultado = produto.getPreco().compareTo(zero);

			if (resultado < 0 || resultado == 0) {
				throw new ValidacaoException("Preço não pode ser negativo e/ou é obrigatório.");
			}

		}

	}
