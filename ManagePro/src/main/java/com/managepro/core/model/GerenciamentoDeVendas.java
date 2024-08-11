package com.managepro.core.model;

import java.util.Date;
import java.util.List;
import java.math.BigDecimal;

public class GerenciamentoDeVendas {
	
	
	private Long id;
	private Funcionario funcionario;
    private Date data;
    private BigDecimal preco;
    private TipoPagamento metodoPagamento;
    private List<GerenciamentoDeVendas> produtosVendidos;
    private Cliente cliente;
    
    
    
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

    
    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    
    
    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

  
    
    public TipoPagamento getMetodoPagamento() {
    	return metodoPagamento;
    }

    public void setMetodoPagamento(TipoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }
    
    
    
    public List<GerenciamentoDeVendas> getLista() {
    	return produtosVendidos;
    }
    
    public void setLista(List<GerenciamentoDeVendas> produtosVendidos) {
    	this.produtosVendidos = produtosVendidos;
    }
    
    
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
}
