package br.com.zup.moises.proposta.Cartao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import br.com.zup.moises.proposta.NovaProposta.NovaProposta;

@Entity
public class Cartao {
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;

	@Column(nullable = false)
	private LocalDateTime dataEmissao;

	@Column(nullable = false, unique = true)
	private String numeroCartao;

	@Column(nullable = false)
	private String titular;

	@Column(nullable = false)
	private BigDecimal limite;

	@OneToOne(mappedBy = "cartao")
	private NovaProposta novaProposta;
	
	@Deprecated
	public Cartao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cartao(LocalDateTime dataEmissao, String numeroCartao, String titular, BigDecimal limite,
			NovaProposta novaProposta) {
		this.numeroCartao = numeroCartao;
		this.dataEmissao = dataEmissao;
		this.titular = titular;
		this.limite = limite;
		this.novaProposta = novaProposta;
	}

	public String getId() {
		return id;
	}

	public LocalDateTime getDataEmissao() {
		return dataEmissao;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public String getTitular() {
		return titular;
	}

	public BigDecimal getLimite() {
		return limite;
	}

	public NovaProposta getNovaProposta() {
		return novaProposta;
	}

}
