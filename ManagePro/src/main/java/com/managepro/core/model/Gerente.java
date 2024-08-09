package com.managepro.core.model;

public class Gerente extends Funcionario {
	public double calcularBonificacao() {
		double bonificacao = getSalario() * 0.5;
		return bonificacao;
	}
}
