package br.com.zup.moises.proposta.NovaProposta;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Positive;
import org.hibernate.annotations.GenericGenerator;

import br.com.zup.moises.proposta.AnaliseFinanceira.Status;
import br.com.zup.moises.proposta.Cartao.Cartao;

@Entity
//@Table(name = "proposta")
public class NovaProposta {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;

	@Column(nullable = false, unique = true)
	private String documento;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String endereco;

	@Positive
	@Column(nullable = false)
	private BigDecimal salario;

	@Enumerated(EnumType.STRING)
	private Status status;

	@OneToOne
	private Cartao cartao;

	public NovaProposta() {
		// TODO Auto-generated constructor stub
	}

	public NovaProposta(String documento, String nome, String email, String endereco, BigDecimal salario) {
		this.documento = documento;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.salario = salario;
	}

	public String getId() {
		return id;
	}

	public String getDocumento() {
		return documento;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
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

	public void setStatus(Status status) {
		this.status = status;
	}

	public Cartao getCartao() {

		return cartao;
	}

	// Setter

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}
}
