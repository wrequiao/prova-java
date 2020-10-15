package br.com.confidencecambio.entidade;



import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotEmpty;


public class EntidadeBase {
	
	@NotNull(message = "Nome deve ser informado.")
	@NotEmpty(message = "Nome não pode ser vazio.")
	@Pattern(regexp = "/^ /g", message = "Nome não pode iniciar com espaço em branco.")
	@Pattern(regexp = "/ $/g", message = "Nome não pode terminar com espaço em branco.")
	private String Nome;	
	
	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String primeiroNome() 
	{
		if (Nome != null) 
		{
			if (Nome.length() > 0) 
			{
				var nomeTemp = limpaVetor(Nome.split(" "));
				
				if (nomeTemp.size() > 0)
					return nomeTemp.get(0);
				else
					return Nome;
		
			}
		}
		return "";
	}	

	public String ultimo() 
	{
		if (Nome != null) 
		{
			if (Nome.length() > 0) 
			{
				String nome = "";
				var nomes = limpaVetor(Nome.split(" "));
				nome = nomes.get(nomes.size()-1);
					
				return nome;
			}
		}
		return "";
	}	
	
	public String ultimoNome() 
	{
		if (Nome != null) 
		{
			if (Nome.length() > 0) 
			{
				String nome = "";
				var nomes = limpaVetor(Nome.split(" "));
				
				if (nomes.size() > 1) 
				{
					nomes.remove(0);
					nome = String.join(" ", nomes).trim();
				}
				else
					nome = nomes.get(0);
					
				return nome;
			}
		}
		
		return "";
	}
	
	
	public String nomeAbreviado() 
	{
		if (Nome != null) 
		{
			if (Nome.length() > 0) 
			{
				String nome = "";
				var nomes = limpaVetor(Nome.split(" "));
				if (nomes.size() > 1) 
				{
					nomes.remove(0);
					nomes.remove(nomes.size()-1);
					
					if (nomes.size() > 0) 
					{				
						for(String item : nomes)
						{
							if (item.charAt(0) == (' ')) continue;
							nome += (item.charAt(0) + ". ").toUpperCase();				
						}
					}
								
					nome = this.primeiroNome() + " " + nome + this.ultimo();
				}
				else
					nome = nomes.get(0);
					
				return nome;
			}
		}
		return "";
	}
	
	public String maisuculo() 
	{
		if (Nome != null) 
		{
			if (Nome.length() > 0) 
			{
				return Nome.toUpperCase();
			}
		}
		return "";
	}
	
	
	public List<String> limpaVetor(String[] nomes) 
	{
		List<String> lista = new ArrayList<String>();
		
		for (int i = 0; i < nomes.length; i++) {
			if (!nomes[i].equals("") && !nomes[i].equals(" "))
				lista.add(nomes[i].trim());
		}	
		
		return lista;
	}

	public EntidadeBase() {}
	
}
