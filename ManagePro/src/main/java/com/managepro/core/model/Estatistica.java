package com.managepro.core.model;

import java.math.BigDecimal;

public class Estatistica {
	
	private Long id;
	private Long quantidadeProdutos;
	private Long quantidadeVendas;
	private Long quantidadeFuncionarios;
	private BigDecimal totalGanho;
	
	public Estatistica() {}
	
	public Estatistica(Long id, Long quantidadeProdutos, Long quantidadeVendas, Long quantidadeFuncionarios, BigDecimal totalGanho) {
		this.id = id;
		this.quantidadeProdutos = quantidadeProdutos;
		this.quantidadeVendas = quantidadeVendas;
		this.quantidadeFuncionarios = quantidadeFuncionarios;
		this.totalGanho = totalGanho;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuantidadeProdutos() {
		return quantidadeProdutos;
	}

	public void setQuantidadeProdutos(Long quantidadeProdutos) {
		this.quantidadeProdutos = quantidadeProdutos;
	}

	public Long getQuantidadeVendas() {
		return quantidadeVendas;
	}

	public void setQuantidadeVendas(Long quantidadeVendas) {
		this.quantidadeVendas = quantidadeVendas;
	}

	public Long getQuantidadeFuncionarios() {
		return quantidadeFuncionarios;
	}

	public void setQuantidadeFuncionarios(Long quantidadeFuncionarios) {
		this.quantidadeFuncionarios = quantidadeFuncionarios;
	}

	public BigDecimal getTotalGanho() {
		return totalGanho;
	}

	public void setTotalGanho(BigDecimal totalGanho) {
		this.totalGanho = totalGanho;
	}

}
