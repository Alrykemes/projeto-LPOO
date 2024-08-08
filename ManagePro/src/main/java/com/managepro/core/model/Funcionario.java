package com.managepro.core.model;

import java.math.BigDecimal;
import java.util.Date;

public class Funcionario {
	private String nome;
	private String cpf;
	private String usuario;
	private String senha;
	private Cargos funcao;
	private BigDecimal salario;
	private Date dataAdmissao;
	
	public Funcionario() {}
	
	public Funcionario(String nome, String cpf, String usuario, String senha, Cargos funcao, BigDecimal salario,
			Date dataAdmissao) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.usuario = usuario;
		this.senha = senha;
		this.funcao = funcao;
		this.salario = salario;
		this.dataAdmissao = dataAdmissao;
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
