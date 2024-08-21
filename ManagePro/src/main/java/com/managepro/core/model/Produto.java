package com.managepro.core.model;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Produto {
	private Long codigoProduto;
	private String nomeProduto;
	private int quantidade;
	private String marca;
	private String fornecedor;
	private BigDecimal preco;
	private LocalDate validade; 
	
	public Produto() {}

	public Produto(Long codigoProduto, String nomeProduto, int quantidade, String marca, String fornecedor,
			BigDecimal preco, LocalDate validade) {
		this.codigoProduto = codigoProduto;
		this.nomeProduto = nomeProduto;
		this.quantidade = quantidade;
		this.marca = marca;
		this.fornecedor = fornecedor;
		this.preco = preco;
		this.validade = validade;
	}

	public Long getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Long IdProduto) {
		this.codigoProduto = IdProduto;
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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public LocalDate getValidade() {
		return validade;
	}

	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}

	@Override
	public String toString() {
		return "Produto [codigoProduto=" + codigoProduto + ", nomeProduto=" + nomeProduto + ", quantidade=" + quantidade
				+ ", preco=" + preco + "]";
	}
	

}
