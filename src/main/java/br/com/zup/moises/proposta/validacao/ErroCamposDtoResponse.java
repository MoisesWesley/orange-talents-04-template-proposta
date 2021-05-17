package br.com.zup.moises.proposta.validacao;

public class ErroCamposDtoResponse {
	private String campo;
	private String erro;
	
	public ErroCamposDtoResponse(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
	
	
}
