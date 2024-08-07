package com.managepro.core.model;

import java.time.LocalDate;

public class Cliente {
	private int id;
	private String nome;
	private String cpf;
	private String endereco;
	private String telefone;
	private String email;
	private LocalDate dataCadastro;

	public Cliente(int id, String nome, String cpf, String endereco, String telefone, String email,
			LocalDate dataCadastro) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.dataCadastro = dataCadastro;
	}

	public int getId() {
		return id;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}		
}

