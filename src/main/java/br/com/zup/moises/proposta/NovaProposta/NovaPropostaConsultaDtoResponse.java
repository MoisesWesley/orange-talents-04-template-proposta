package br.com.zup.moises.proposta.NovaProposta;

import java.math.BigDecimal;

import br.com.zup.moises.proposta.AnaliseFinanceira.Status;

public class NovaPropostaConsultaDtoResponse {
	
	private String email;
	
	private String nome;
	
	private String endereco;
	
	private BigDecimal salario;
	
	private Status status;

	@Deprecated
	public NovaPropostaConsultaDtoResponse() {
		// TODO Auto-generated constructor stub
	}

	public NovaPropostaConsultaDtoResponse(NovaProposta novaProposta) {
		this.email = novaProposta.getEmail();
		this.nome = novaProposta.getNome();
		this.endereco = novaProposta.getEndereco();
		this.salario = novaProposta.getSalario();
		this.status = novaProposta.getStatus();
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

	public Status getStatus() {
		return status;
	}
}
