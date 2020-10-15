package br.com.confidencecambio.entidade;

public class Robo extends EntidadeBase{

	
	public Robo() {
		super();
	}
	
	public Robo(String modelo) {
		super();
		this.modelo = modelo;
	}
	
	public Robo(String modelo, String nome) {
		super();
		this.modelo = modelo;
		this.setNome(nome);
	}
	
	private String modelo;

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}	
	
}
