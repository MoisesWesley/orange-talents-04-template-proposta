package br.com.zup.moises.proposta.AnaliseFinanceira;

public class AnaliseDePropostaRequest {

	private String documento;
	private String nome;
	private String idProposta;
	
	//@Deprecated apenas para uso do framework
	@Deprecated
	public AnaliseDePropostaRequest() {
	}

	public AnaliseDePropostaRequest(String documento, 
									String nome, 
									String idProposta) {
		this.documento = documento;
		this.nome = nome;
		this.idProposta = idProposta;
	}

	public String getDocumento() {
		return documento;
	}

	public String getNome() {
		return nome;
	}
	
	public String getIdProposta() {
		return idProposta;
	}	
}
