package br.com.zup.moises.proposta.NovaProposta;

import java.math.BigDecimal;

public class NovaPropostaDtoResponse {

	private String id;

	private String documento;

	private String email;

	private String nome;
	
	private String endereco;
	
	private BigDecimal salario;

	public NovaPropostaDtoResponse(NovaProposta novaProposta) {
		this.id = novaProposta.getId();
		this.documento = novaProposta.getDocumento();
		this.email = novaProposta.getEmail();
		this.nome = novaProposta.getNome();
		this.endereco = novaProposta.getEndereco();
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

	public String getEndereco() {
		return endereco;
	}
	
	public BigDecimal getSalario() {
		return salario;
	}

}
