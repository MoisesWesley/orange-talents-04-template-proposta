package br.com.zup.moises.proposta.NovaProposta;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NovaPropostaRepository extends JpaRepository<NovaProposta, String> {

	//buscando se um documento existe no banco de dados.
	boolean existsByDocumento(String documento);

}
