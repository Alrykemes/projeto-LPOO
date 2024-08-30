package com.managepro.core.model;

import java.math.BigDecimal;
import java.util.Date;

public class Estatistica {
	
	private Long id;
	private Long quantidadeProdutos;
	private Long quantidadeVendas;
	private BigDecimal totalGanho;
	private Date data;
	
	public Estatistica() {}
	
	public Estatistica(Long id, Long quantidadeProdutos, Long quantidadeVendas, BigDecimal totalGanho, Date data) {
		this.id = id;
		this.quantidadeProdutos = quantidadeProdutos;
		this.quantidadeVendas = quantidadeVendas;
		this.totalGanho = totalGanho;
		this.data = data;
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


	public BigDecimal getTotalGanho() {
		return totalGanho;
	}

	public void setTotalGanho(BigDecimal totalGanho) {
		this.totalGanho = totalGanho;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
