package br.com.zup.moises.proposta.Cartao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.zup.moises.proposta.NovaProposta.NovaProposta;
import br.com.zup.moises.proposta.NovaProposta.NovaPropostaRepository;

public class SolicitaCartaoResponse {

	private String id; // aqui o id que vem da requisição do serviço vem como o numero do cartao
	private LocalDateTime emitidoEm;
	private String titular;
	private BigDecimal limite;
	private String idProposta;

	/*
	 * private Long id; private String numero; private String titular; private
	 * LocalDateTime emitidoEm; private Integer limite;
	 */

	public String getId() {
		return id;
	}

	public LocalDateTime getEmitidoEm() {
		return emitidoEm;
	}

	public String getTitular() {
		return titular;
	}

	public BigDecimal getLimite() {
		return limite;
	}

	public String getIdProposta() {
		return idProposta;
	}

	public Cartao toModel(NovaPropostaRepository novaPropostaRepository) {
		NovaProposta novaProposta = novaPropostaRepository.findById(idProposta).get();
		return new Cartao(emitidoEm, id, titular, limite, novaProposta);
	}
}
