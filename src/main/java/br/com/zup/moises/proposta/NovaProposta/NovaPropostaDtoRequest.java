package br.com.zup.moises.proposta.NovaProposta;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

import br.com.zup.moises.proposta.validacao.ValidaCpfOuCnpj;

public class NovaPropostaDtoRequest {
	@NotBlank
	@ValidaCpfOuCnpj
	private String documento;

	@NotBlank
	@Length(min = 3)
	private String nome;
	
	@NotBlank
	private String email;

	@NotBlank
	private String endereco;

	@NotNull
	@Positive
	private BigDecimal salario;

	@Deprecated
	public NovaPropostaDtoRequest() {
	}

	// passando os valores que vem da requisição sem a mascaca do documento cpf caso
	// tiver
	public NovaPropostaDtoRequest(String documento, String nome,String email, String endereco, BigDecimal salario) {
		this.documento = documento.replaceAll("[\\.\\-\\/]", "");
		this.nome = nome;
		this.email = email;
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

		return new NovaProposta(documento, nome, email, endereco, salario);
	}

}
