package com.managepro.core.model;

public abstract class funcionario {
	private String nome;
	private String cpf;
	private String senha;
	private String email;
	private String cargo;
	private double salario;
	private String dataAdmissao;
	private int frequencia;
	
	// Construtor de funcionário
	public void Funcionario(String nome, String cpf, String senha, String email, String cargo, double salario, String dataAdmissao, int frequencia) {
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.email = email;
		this.cargo = cargo;
		this.salario = salario;
		this.dataAdmissao = dataAdmissao;
		this.frequencia = frequencia;
	}
	
	// Getters e Setters
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getCargo() {
		return cargo;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public String getDataAdmissao() {
		return dataAdmissao;
	}
	
	public void setDataAdmissao(String dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	
	public int getFrequencia() {
		return frequencia;
	}
	
	public void setFrequencia(int frequencia) {
		this.frequencia = frequencia;
	}
	
	public double calcularBonificacao () {
		double bonificacao = salario;
		return bonificacao;
	}
	
	//Método toString
	@Override
	public String toString() {
		return "Funcionario{" +
				"nome='" + nome + '\'' +
				", cpf='" + cpf + '\'' +
				", email='" + email + '\'' +
				", cargo='" + cargo + '\'' +
				", salario='" + salario + '\'' +
				", dataAdmissao='" + dataAdmissao + '\'' +
				", frequencia='" + frequencia + '\'' +
				'}';
	}
}
