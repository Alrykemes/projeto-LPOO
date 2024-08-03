package com.managepro.core.model;

public class Cliente {
	private String nome;
	private String cpf;
	private double precoCompras;
	
	public Cliente(double precoCompras) {
		this.precoCompras = precoCompras;
	}
	
	public Cliente(String nome, String cpf, double precoCompras) {
		this.nome = nome;
		this.cpf = cpf;
		this.precoCompras = precoCompras;
	}
	
	public String getNome() {
		return nome;
	}	
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getPrecoCompras() {
		return precoCompras;
	}

	public void setPrecoCompras(double precoCompras) {
		this.precoCompras = precoCompras;
	}
	
	
	
}
