package br.com.confidencecambio.javabasico;


import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import br.com.confidencecambio.entidade.Cliente;
import br.com.confidencecambio.entidade.EntidadeBase;

public class Validacoes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntidadeBase entidade = new EntidadeBase();
		//entidade.setNome(" Maria Madalena Batista Silva");
		entidade.setNome("");
		 System.out.println (entidade.primeiroNome());
		 System.out.println (entidade.maisuculo());
		 System.out.println (entidade.ultimoNome());
		 System.out.println (entidade.nomeAbreviado());
		 
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator ();

		Set<ConstraintViolation<EntidadeBase>> constraintViolations = validator.validate(entidade);

		for (ConstraintViolation error: constraintViolations) 
		{
	      String msgError = error.getMessage();
	      System.out.println (msgError);
		}
		
		/*
		Cliente cliente = new Cliente("12345", "Maria de Deus");
		 System.out.println (cliente.primeiroNome());
		 System.out.println (cliente.maisuculo());
		 System.out.println (cliente.ultimoNome());
		 System.out.println (cliente.nomeAbreviado());
		
		
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator ();

		Set<ConstraintViolation<EntidadeBase>> constraintViolationsCliente = validator.validate(cliente);

		for (ConstraintViolation error: constraintViolationsCliente) 
		{
	      String msgError = error.getMessage();
	      System.out.println (msgError);
		}
		*/
	}

}
