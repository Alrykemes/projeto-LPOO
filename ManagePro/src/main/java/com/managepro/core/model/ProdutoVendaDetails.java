package com.managepro.core.model;

import java.math.BigDecimal;

public class ProdutoVendaDetails {
	
	private Long codigoProduto;
	private String nomeProduto;
	private int quantidade;
	private BigDecimal preco;
	
	public ProdutoVendaDetails() {}

	public ProdutoVendaDetails(Long codigoProduto, String nomeProduto, int quantidade, BigDecimal preco) {
		this.codigoProduto = codigoProduto;
		this.nomeProduto = nomeProduto;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public Long getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Long codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
        return nomeProduto + " | Quantidade: " + quantidade + " | Preço: R$ " + String.format("%.2f", preco);
    }
	
}
