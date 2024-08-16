package com.managepro.core.model;
import java.math.BigDecimal;

public class Produto {
	private Long IdProduto;
	private String nomeProduto;
	private BigDecimal preco;
	private int quantidade;
	private String marca;
	private String fornecedor;
	
	public Produto(Long i, String nomeProduto, BigDecimal preco, int quantidade, String marca, String fornecedor) {
		this.IdProduto = i;
		this.nomeProduto = nomeProduto;
		this.preco = preco;
		this.quantidade = quantidade;
		this.marca = marca;
		this.fornecedor = fornecedor;
	}

	public Long getIdProduto() {
		return IdProduto;
	}

	public void setIdProduto(Long IdProduto) {
		this.IdProduto = IdProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	

}
