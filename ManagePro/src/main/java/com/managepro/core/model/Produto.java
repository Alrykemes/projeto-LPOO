package com.managepro.core.model;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Produto {
	private Long id_produto;
	private String nomeProduto;
	private BigDecimal preco;
	private int quantidade;
	private String marca;
	private String fornecedor;
	private LocalDate validade;
	
	public Produto() {}
	
	public Produto(Long id_produto, String nomeProduto, BigDecimal preco, int quantidade, String marca, String fornecedor, LocalDate validade) {
		this.id_produto = id_produto;
		this.nomeProduto = nomeProduto;
		this.preco = preco;
		this.quantidade = quantidade;
		this.marca = marca;
		this.fornecedor = fornecedor;
		this.validade = validade;
	}

	public Long getCodigoProduto() {
		return id_produto;
	}

	public Produto(String nomeProduto, BigDecimal preco, int quantidade, String marca, String fornecedor, LocalDate validade) {
		this.nomeProduto = nomeProduto;
		this.preco = preco;
		this.quantidade = quantidade;
		this.marca = marca;
		this.fornecedor = fornecedor;
		this.validade = validade;
	}

	public void setCodigoProduto(Long codigoProduto) {
		this.id_produto = codigoProduto;
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
	
	public LocalDate getValidade() {
		return validade;
	}
	
	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}
}
