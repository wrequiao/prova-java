package br.com.confidencecambio.entidade;

public class Gerente extends EntidadeBase{
	
	public Gerente() {
		super();
	}
	
	public Gerente(String setor) {
		super();
		this.setor = setor;
	}
	
	public Gerente(String setor, String nome) {
		super();
		this.setor = setor;
		this.setNome(nome);
	}
	
	private String setor;

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}	

}
