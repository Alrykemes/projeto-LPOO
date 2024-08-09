package com.managepro.core.model;

public class Estoquista extends Funcionario {
	public double calcularBonificacao() {
		double bonificacao = getSalario() * 0.25;
		return bonificacao;
	}
}
