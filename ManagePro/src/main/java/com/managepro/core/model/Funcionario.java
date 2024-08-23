package com.managepro.core.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario {
	private Long id;
	private String nome;
	private String cpf;
	private String telefone;
	private Cargos funcao;
	private BigDecimal salario;
	private LocalDate dataAdmissao;
	private String usuario;
	private String senha;
	
	public Funcionario() {}
	
	public Funcionario(String nome, String cpf, Cargos funcao, BigDecimal salario,
			LocalDate dataAdmissao, String telefone, String usuario, String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.funcao = funcao;
		this.salario = salario;
		this.dataAdmissao = dataAdmissao;
		this.telefone = telefone;
		this.usuario = usuario;
		this.senha = senha;
	}
	
	public Funcionario(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
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
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Cargos getFuncao() {
		return funcao;
	}
	public void setFuncao(Cargos funcao) {
		this.funcao = funcao;
	}
	public BigDecimal getSalario() {
		return salario;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}
	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	
	
}
