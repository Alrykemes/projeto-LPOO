
public class Admin extends Funcionario {
	
	private String NivelAcesso;
	
	public Admin(String nome, String senha, String email, String cargo, String dataAdmissao, int frequencia, String NivelAcesso);
		super(nome, senha, email, cargo, dataAdmissao, frequencia, nivel acesso);
		
		public Admin() {
			super();
		}
		
		public String NivelAcesso() {
			return NivelAcesso;
		}
		
		public void setNivelAcesso(String NivelAcesso) {
			this.NivelAcesso = NivelAcesso;
		}
	
	
}
