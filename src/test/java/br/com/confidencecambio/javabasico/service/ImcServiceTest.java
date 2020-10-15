package br.com.confidencecambio.javabasico.service;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import br.com.confidencecambio.entidade.Imc;
import br.com.confidencecambio.exception.GeneralException;
import io.restassured.RestAssured;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ImcServiceTest {

	@LocalServerPort
    private int port;
	
	@Autowired
	private ImcService imcService;	

    @Before
    public void init(){
    	this.imcService = new ImcService();
    }
    
	@Test
	public void PesoTeste() {
		 Imc imc = imcService.calcularIMC("1", "5");
		 assertEquals(imc.getImc(), 25);
	}
	
	@Test
	public void AlturaTeste() {
		var imc = imcService.calcularIMC("5", "1");
		 assertEquals(imc.getImc(), 5);
	}	
	
	@Test
	public void AlturaPesoTeste() {
		var imc = imcService.calcularIMC("5", "5");
		 assertEquals(imc.getImc(), 125);
	}	
	
	@Test
	public void PesoZeroTeste() {
		Assertions.assertThrows(GeneralException.class, () -> {
			imcService.calcularIMC("0", "5");
		  });
	}
	
	@Test
	public void AlturaZeroTeste() {
		Assertions.assertThrows(GeneralException.class, () -> {
			imcService.calcularIMC("5", "0");
		  });
	}
	
	@Test
	public void AlturaInvalidaTeste() {
		Assertions.assertThrows(GeneralException.class, () -> {
			imcService.calcularIMC("5", "A");
		  });
	}
	
	@Test
	public void PesoInvalidoTeste() {
		Assertions.assertThrows(GeneralException.class, () -> {
			imcService.calcularIMC("X", "10");
		  });
	}
	
	
	@Test
	public void deveRetornar200ConsultaImc() {
		RestAssured.given()
		.port(port)
		.when().get("/api/imc/3/8")
		.then().statusCode(200);
		
	}
	
	
	@Test
	public void deveRetornar200ConsultaValorImc() {
		RestAssured.given()
		.pathParam("peso", 3)
		.pathParam("altura", 8)
		.port(port)
		.when().get("/api/imc/valor/{peso}/{altura}")
		.then().statusCode(HttpStatus.OK.value());
		
	}
	
	
	@Test
	public void deveRetornar404ConsultaValorImc() {
		RestAssured.given()
		.pathParam("peso", 3)
		.pathParam("altura", 8)
		.pathParam("outro", 10)
		.port(port)
		.when().get("/api/imc/valor/{peso}/{altura}/{outro}")
		.then().statusCode(HttpStatus.NOT_FOUND.value());
		
	}
	
	
	@Test
	public void deveRetornar500ConsultaValorImc() {
		RestAssured.given()
		.pathParam("peso", 3)
		.pathParam("altura", 0)
		.port(port)
		.when().get("/api/imc/valor/{peso}/{altura}")
		.then().statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());		
	}	
}
