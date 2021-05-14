package br.com.zup.moises.proposta.Controller;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

import br.com.zup.moises.proposta.Controller.ValidaCpfOuCnpj;

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

}
