package com.managepro.core.model;

public class gerente extends funcionario {
	public double calcularBonificacao() {
		double bonificacao = get.Salario * 0.2;
		return bonificacao;
	}
}
