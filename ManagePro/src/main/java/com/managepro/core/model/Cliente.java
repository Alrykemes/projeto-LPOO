package com.managepro.core.model;

import java.time.LocalDate;

public class Cliente {
	private Long id;
	private String nome;
	private String cpf;
	// private String endereco;
	// private String telefone;
	// private String email;
	private LocalDate dataNascimento;

	public Cliente() {}

	public Cliente(Long id, String nome, String cpf, /*String endereco, String telefone, String email,*/
			LocalDate dataNascimento) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		// this.endereco = endereco;
		// this.telefone = telefone;
		// this.email = email;
		this.dataNascimento = dataNascimento;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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
/*
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
*/
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}		
}