package com.managepro.core.model;

public class Vendedor extends Funcionario {
	public double calcularBonificacao() {
		double bonificacao = getSalario() * 0.1;
		return bonificacao;
	}
}
