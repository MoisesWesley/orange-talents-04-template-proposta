package br.com.zup.moises.proposta.Cartao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.zup.moises.proposta.AnaliseFinanceira.Status;
import br.com.zup.moises.proposta.NovaProposta.NovaProposta;
import br.com.zup.moises.proposta.NovaProposta.NovaPropostaRepository;
import feign.FeignException;

@Component
public class CartaoScheduled {
	@Autowired
	private NovaPropostaRepository novaPropostaRepository;
	
	@Autowired
	private CartaoRepository cartaoRepository;
	
	@Autowired
	private BuscarCartaoClient buscarCartaoClient;
	
	@Scheduled(fixedDelay = 60 * 1000)
	public void VincularCartaoScheduled() {
		
		List<NovaProposta> novasPropostas = novaPropostaRepository.findByCartaoAndStatus(Status.ELEGIVEL);
		
		for (NovaProposta novaProposta : novasPropostas) {
			try {
				SolicitaCartaoResponse solicitaCartaoResponse = buscarCartaoClient.dadosCartao(novaProposta.getId());
				Cartao cartao = solicitaCartaoResponse.toModel(novaPropostaRepository);
				//salar aqui repositiry
				cartaoRepository.save(cartao);
				novaProposta.setCartao(cartao);
				novaPropostaRepository.save(novaProposta);
				
				System.out.println("Titular: " + novaProposta.getNome() + " Proposta de documento: " + novaProposta.getDocumento() + "cartao: "+ novaProposta.getId() +" criados com sucesso!");
			} catch (FeignException e) {
				e.printStackTrace();
			}
		}
	}
}
