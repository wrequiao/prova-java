package br.com.confidencecambio.entidade;

public class Cliente extends EntidadeBase{
	public Cliente() {
		super();
	}
	
	public Cliente(String matricula) {
		super();
		this.matricula = matricula;
	}
	
	public Cliente(String matricula, String nome) {
		super();
		this.matricula = matricula;
		this.setNome(nome);
	}
	
	private String matricula;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
}
