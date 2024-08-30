package com.managepro.core.service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.managepro.core.model.Produto;
import com.managepro.dao.ProdutoDAO;
import com.managepro.exceptions.ExcecaoDoSistema;
import com.managepro.exceptions.ValidacaoException;

public class ProdutoService {

	//private Produto produto;
	private ProdutoDAO produtoDAO;
	
	public ProdutoService() {
		produtoDAO = new ProdutoDAO();
	}

	public Produto getProductById(Long codigoProduto) throws ExcecaoDoSistema {
		return produtoDAO.findProductById(codigoProduto);
	}
	
	public void adicionarProduto(Produto produto) throws ValidacaoException, ExcecaoDoSistema {
		validacao(produto);
		produtoDAO.newProduct(produto);
	}
	
	public List<Produto> pesquisarProdutoPorNome(String nomeProduto){
		return produtoDAO.pesquisarProdutoNome(nomeProduto);
	}
	
	public List<Produto> pesquisarProdutoPorId(Long id) throws ExcecaoDoSistema{
		return produtoDAO.pesquisarProdutoID(id);
	}

	public List<Produto> pesquisarProdutoValidade(LocalDate validade) throws ClassNotFoundException, SQLException, ExcecaoDoSistema{
		return produtoDAO.pesquisarProdutoValidade(validade);
	}

	public List<Produto> listarProdutos() throws ExcecaoDoSistema  {
		try {
			return produtoDAO.getTodosProdutos();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void removerProduto(Long codigoProduto) throws ExcecaoDoSistema {
		produtoDAO.removerProduto(codigoProduto);
	}

	public void atualizarProduto(Produto produto) throws ValidacaoException, ExcecaoDoSistema {
		validacao(produto);
		produtoDAO.editarProduto(produto);	
	}


	public void validacao(Produto produto) throws ValidacaoException {

		// exce��es buscar produto

			if (produto == null) {
				throw new ValidacaoException("Produto n�o existe.");
			}

			// exce��es gerais do produto

			if (produto.getNomeProduto() == null) {
			throw new ValidacaoException("Nome do produto � obrigat�rio");
			}
			
			if (produto.getMarca() == null) {
				throw new ValidacaoException("Marca � obrigat�ria.");
			}

			if (produto.getPreco() == null) {
				throw new ValidacaoException("Pre�o � obrigat�rio.");
			}
			
			BigDecimal zero = new BigDecimal(0);
			int resultado = produto.getPreco().compareTo(zero);

			if (resultado < 0 || resultado == 0) {
				throw new ValidacaoException("Pre�o n�o pode ser negativo e/ou � obrigat�rio.");
			}

		}

	}