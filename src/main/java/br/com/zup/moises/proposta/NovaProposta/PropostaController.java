package br.com.zup.moises.proposta.NovaProposta;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.moises.proposta.AnaliseFinanceira.AnaliseDePropostaRequest;
import br.com.zup.moises.proposta.AnaliseFinanceira.AnaliseDePropostaResponse;
import br.com.zup.moises.proposta.AnaliseFinanceira.AnaliseSolicitacaoClient;
import br.com.zup.moises.proposta.AnaliseFinanceira.Status;
import feign.FeignException;

@RestController
@RequestMapping("/proposta")
public class PropostaController {

	@Autowired
	private NovaPropostaRepository novaPropostaRepository;

	@Autowired
	private AnaliseSolicitacaoClient analiseClient;

// podemos tambem fazer a injecao via construtor confirme abaixo
//public PropostaController(NovaPropostaRepository novaPropostaRepository,
//			AnaliseSolicitacaoClient analiseSolicitacaoClient) {
//		this.novaPropostaRepository = novaPropostaRepository;
//		this.analiseSolicitacaoClient = analiseSolicitacaoClient;
//	}
//
//
//	public PropostaController(NovaPropostaRepository novaPropostaRepository) {
//
//		this.novaPropostaRepository = novaPropostaRepository;
//	}

	@PostMapping
	public ResponseEntity<NovaPropostaDtoResponse> cadastrar(
			@RequestBody @Valid NovaPropostaDtoRequest novaPropostaDtoRequest,
			UriComponentsBuilder uriComponentsBuilder) {

		if (novaPropostaRepository.existsByDocumento(novaPropostaDtoRequest.getDocumento())) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
		}

		NovaProposta novaProposta = novaPropostaDtoRequest.toModelConverter();
		novaPropostaRepository.save(novaProposta); // a transação termina aqui entao todo bloco de codigo abaixo nao foi
													// executado dentro da transação portando nao salvou
													// uma maneira de resolver e colocando
													// novaPropostaRepository.save(novaProposta); la no final ou
													// colocando a anotacao
													// @transaction em cima da class

		// consultar dados da proposta
		try {
			AnaliseDePropostaRequest analiseRequest = new AnaliseDePropostaRequest(novaProposta.getDocumento(),
					novaProposta.getNome(), novaProposta.getId());

			AnaliseDePropostaResponse resultadoDaConsulta = analiseClient.consulta(analiseRequest);

//			Status status = resultadoDaConsulta.getResultadoSolicitacao().getStatus();					//aqui temos uma quebra de encapsulamento de classe lei de demeter, get's encadeados
			Status status = resultadoDaConsulta.status();
			novaProposta.setStatus(status);
		} catch (FeignException.UnprocessableEntity unprocessableEntity) {
			novaProposta.setStatus(Status.NAO_ELEGIVEL);
		} catch (FeignException.ServiceUnavailable serviceUnvailable) {
			novaPropostaRepository.delete(novaProposta);
		}

		novaPropostaRepository.save(novaProposta);			//salvando aqui tambem para persistir o restante das informacoes que foram adicionadas posteriormente
		URI uriNovaProposta = uriComponentsBuilder.path("/proposta/{id}").build(novaProposta.getId());

		return ResponseEntity.created(uriNovaProposta).body(new NovaPropostaDtoResponse(novaProposta));

	}
}