package com.managepro.core.model;

public class estoquista extends funcionario {
	public double calcularBonificacao() {
		double bonificacao = salario * 0.2;
		return bonificacao;
	}
}
