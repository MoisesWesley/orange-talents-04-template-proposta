package br.com.zup.moises.proposta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.moises.proposta.modelo.NovaProposta;

public interface NovaPropostaRepository extends JpaRepository<NovaProposta, String>{

}
