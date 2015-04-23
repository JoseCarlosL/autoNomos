package java;

public class Endereco {
	private String rua;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;

	public Endereco(String rua, String numero, String complemento,
			String bairro, String cidade, String estado, String cep) {
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}

	protected String getRua() {
		return rua;
	}

	protected void setRua(String rua) {
		this.rua = rua;
	}

	protected String getNumero() {
		return numero;
	}

	protected void setNumero(String numero) {
		this.numero = numero;
	}

	protected String getComplemento() {
		return complemento;
	}

	protected void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	protected String getBairro() {
		return bairro;
	}

	protected void setBairro(String bairro) {
		this.bairro = bairro;
	}

	protected String getCidade() {
		return cidade;
	}

	protected void setCidade(String cidade) {
		this.cidade = cidade;
	}

	protected String getEstado() {
		return estado;
	}

	protected void setEstado(String estado) {
		this.estado = estado;
	}

	protected String getCep() {
		return cep;
	}

	protected void setCep(String cep) {
		this.cep = cep;
	}

}
