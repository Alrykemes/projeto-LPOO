package com.managepro.core.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Venda {

	private Long id;
	private Funcionario funcionario;
	private Cliente cliente;
	private List<ProdutoVendaDetails> produtosVendidos;
	private FormaPagamento formaDePagamentoEnum;
	private LocalDate data;
	private BigDecimal preco;
	private BigDecimal valorRecebido;
	private BigDecimal troco;

	public Venda() {
	}

	public Venda(Long id, Funcionario funcionario, Cliente cliente, List<ProdutoVendaDetails> produtosVendidos,
			FormaPagamento formaDePagamentoEnum, LocalDate data, BigDecimal preco, BigDecimal valorRecebido,
			BigDecimal troco) {
		this.id = id;
		this.funcionario = funcionario;
		this.cliente = cliente;
		this.produtosVendidos = produtosVendidos;
		this.formaDePagamentoEnum = formaDePagamentoEnum;
		this.data = data;
		this.preco = preco;
		this.valorRecebido = valorRecebido;
		this.troco = troco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ProdutoVendaDetails> getProdutosVendidos() {
		return produtosVendidos;
	}

	public void setProdutosVendidos(List<ProdutoVendaDetails> produtosVendidos) {
		this.produtosVendidos = produtosVendidos;
	}

	public FormaPagamento getFormaDePagamentoEnum() {
		return formaDePagamentoEnum;
	}

	public void setFormaDePagamentoEnum(FormaPagamento formaDePagamentoEnum) {
		this.formaDePagamentoEnum = formaDePagamentoEnum;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public BigDecimal getValorRecebido() {
		return valorRecebido;
	}

	public void setValorRecebido(BigDecimal valorRecebido) {
		this.valorRecebido = valorRecebido;
	}

	public BigDecimal getTroco() {
		return troco;
	}

	public void setTroco(BigDecimal troco) {
		this.troco = troco;
	}

	@Override
	public String toString() {
		return "ID: " + id + "| Data: " + data + "| Preco: " + String.format("R$ %.2f", preco);
	}

}