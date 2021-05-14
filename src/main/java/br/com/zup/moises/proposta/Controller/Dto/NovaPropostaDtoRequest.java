package br.com.zup.moises.proposta.Controller.Dto;

import java.math.BigDecimal;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

import br.com.zup.moises.proposta.Controller.ValidaCpfOuCnpj;
//Request e usado para requisicao/ solicitar dados no banco 
import br.com.zup.moises.proposta.modelo.NovaProposta;

public class NovaPropostaDtoRequest {
	@NotBlank
	@ValidaCpfOuCnpj
	private String documento;

	@NotBlank
	private String email;

	@NotBlank
	@Length(min = 3)
	private String nome;

	@NotBlank
	private String endereco;

	@NotNull
	@Positive
	private BigDecimal salario;
	
	

	public NovaPropostaDtoRequest() {
		// TODO Auto-generated constructor stub
	}
	
	
	//
	public NovaPropostaDtoRequest(String documento, String email, String nome, String endereco, BigDecimal salario) {
		this.documento = documento.replaceAll("[\\.\\-\\/]", "");
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
	}



	public String getDocumento() {
		return documento;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public NovaProposta toModelConverter() {

		return new NovaProposta(documento, email, nome, endereco, salario);
	}

}
