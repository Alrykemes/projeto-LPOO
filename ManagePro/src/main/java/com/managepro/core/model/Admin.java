package teste;

import teste.Funcionario;
import teste.String;

public class Admin extends Funcionario {
	
	private String nivelAcesso;
	
	public Admin(String nome, String email, String cpf, String nivelAcesso) {
		super(nome, email, cpf);
		this.nivelAcesso = nivelAcesso;
	}
	
	public Admin() {
		super();
	}

	public String getNivelAcesso() {
		return nivelAcesso;
	}

	public void setNivelAcesso(String nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}
	
	
	
	
}
