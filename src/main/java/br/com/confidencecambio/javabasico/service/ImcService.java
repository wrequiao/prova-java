package br.com.confidencecambio.javabasico.service;

import org.springframework.stereotype.Service;

import br.com.confidencecambio.entidade.Imc;
import br.com.confidencecambio.exception.GeneralException;

@Service
public class ImcService {

	public Imc calcularIMC(String peso, String altura)
	{
		
		try 
		{
			Double.parseDouble(peso);
		}
		catch(NumberFormatException ex) 
		{
			throw new GeneralException("Formato do Peso inválido.");
		}
		
		try 
		{
			Double.parseDouble(altura);
		}
		catch(NumberFormatException ex) 
		{
			throw new GeneralException("Formato da Altura inválido.");
		}
		
		if (Double.parseDouble(peso) <= 0)
			throw new GeneralException("Peso deve ser maior que zero.");
		
		if (Double.parseDouble(altura) <= 0)
			throw new GeneralException("Altura deve ser maior que zero.");
		
		
		Imc imc = new Imc(Double.parseDouble(peso), Double.parseDouble(altura));
		return imc;
	}	
}
