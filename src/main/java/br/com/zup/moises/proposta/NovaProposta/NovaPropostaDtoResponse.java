package br.com.zup.moises.proposta.NovaProposta;

import java.math.BigDecimal;

public class NovaPropostaDtoResponse {

	private String id;

	private String documento;

	private String email;

	private String nome;
	
	private BigDecimal salario;

	public NovaPropostaDtoResponse(NovaProposta novaProposta) {
		this.id = novaProposta.getId();
		this.documento = novaProposta.getDocumento();
		this.nome = novaProposta.getNome();
		this.email = novaProposta.getEmail();
		this.salario = novaProposta.getSalario();
	}

	public String getId() {
		return id;
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

	public BigDecimal getSalario() {
		return salario;
	}

}
