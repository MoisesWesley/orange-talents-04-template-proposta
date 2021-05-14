package br.com.zup.moises.proposta.Controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.moises.proposta.Controller.Dto.NovaPropostaDtoRequest;
import br.com.zup.moises.proposta.Controller.Dto.NovaPropostaDtoResponse;
import br.com.zup.moises.proposta.modelo.NovaProposta;
import br.com.zup.moises.proposta.repository.NovaPropostaRepository;

@RestController
@RequestMapping("/proposta")
public class PropostaController {
	
	private NovaPropostaRepository novaPropostaRepository;


	public PropostaController(NovaPropostaRepository novaPropostaRepository) {

		this.novaPropostaRepository = novaPropostaRepository;
	}
	@PostMapping
	public ResponseEntity<NovaPropostaDtoResponse> cadastrar(@RequestBody @Valid NovaPropostaDtoRequest novaPropostaDtoRequest, UriComponentsBuilder uriComponentsBuilder) {
		NovaProposta novaProposta = novaPropostaDtoRequest.toModelConverter();
		novaPropostaRepository.save(novaProposta);

		URI uriNovaProposta = uriComponentsBuilder.path("/proposta/{id}").build(novaProposta.getId());
        return ResponseEntity.created(uriNovaProposta).body(new NovaPropostaDtoResponse(novaProposta));
	}
}
