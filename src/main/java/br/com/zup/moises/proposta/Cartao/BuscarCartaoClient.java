package br.com.zup.moises.proposta.Cartao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "vincular-Cartao", url = "http://contas:8888")
public interface BuscarCartaoClient {
	@GetMapping("/api/cartoes")
	SolicitaCartaoResponse dadosCartao(@RequestParam(name="idProposta") String idProposta);
}
