package com.managepro.core.model;

import java.math.BigDecimal;
import java.util.Date;

	public class Funcionario {
	private String telefone;
	private Long id;
	private String nome;
	private String cpf;
	private Cargos funcao;
	private BigDecimal salario;
	private Date dataAdmissao;
	private String usuario;
	private String senha;
	
	public Funcionario() {}
	
	public Funcionario(String telefone, Long id, String nome, String cpf, Cargos funcao, BigDecimal salario,
			Date dataAdmissao, String usuario, String senha) {
		super();
		this.telefone = telefone;
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.funcao = funcao;
		this.salario = salario;
		this.dataAdmissao = dataAdmissao;
		this.usuario = usuario;
		this.senha = senha;
	}
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
	public Date getDataAdmissao() {
		return dataAdmissao;
	}
	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
}
