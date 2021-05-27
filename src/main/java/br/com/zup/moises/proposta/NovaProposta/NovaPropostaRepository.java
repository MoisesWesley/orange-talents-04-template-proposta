package br.com.zup.moises.proposta.NovaProposta;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.zup.moises.proposta.AnaliseFinanceira.Status;

public interface NovaPropostaRepository extends JpaRepository<NovaProposta, String> {

	//buscando se um documento existe no banco de dados.
	boolean existsByDocumento(String documento);
	
//	List<NovaProposta> findByStatus(Status ELEGIVEL);

	@Query ("select p from NovaProposta p where p.status = :status and p.cartao is null")
	List<NovaProposta> findByCartaoAndStatus(Status status);

}
