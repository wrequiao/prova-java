package br.com.confidencecambio.javabasico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.confidencecambio.entidade.Imc;
import br.com.confidencecambio.javabasico.service.ImcService;


@CrossOrigin("*")
@RequestMapping("/api/imc")
@RestController
public class ImcController {
	
	@Autowired
	private ImcService imcService;

	@GetMapping(value = "/{peso}/{altura}")
	public Imc imc(@PathVariable(name = "peso", required = true) String peso, @PathVariable(name = "altura", required = true) String altura) 
	{
		return imcService.calcularIMC(peso, altura);
	}
	
	@GetMapping(value = "/valor/{peso}/{altura}")
	public Double imcValor(@PathVariable(name = "peso", required = true) String peso, @PathVariable(name = "altura", required = true) String altura) 
	{
		return imcService.calcularIMC(peso, altura).getImc();
	}
}
