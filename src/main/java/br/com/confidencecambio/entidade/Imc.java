package br.com.confidencecambio.entidade;

import java.io.Serializable;

public class Imc implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Double peso;
	private Double altura;
	private Double imc;
	
	public Imc() {};
	
	public Imc(Double peso, Double altura) 
	{
		this.altura = altura;
		this.peso = peso;
		this.calcularImc();
	}	
	
	public Double calcularImc() 
	{
		imc = peso*(altura*altura);
		return imc;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getImc() {
		return imc;
	}

	public void setImc(Double imc) {
		this.imc = imc;
	}
	
	
	
}
