package LojaCadastro.Controller.Form;

import javax.validation.constraints.NotBlank;


import LojaCadastro.Modelo.Endereco;
import LojaCadastro.Repository.RepositoryEndereco;

///////////////CLASSE FORM////////////
	public class EnderecoForm {
	@NotBlank
	private String estado;
	
	@NotBlank
	private String cidade;
	
	@NotBlank
	private String cep;
	
	@NotBlank
	private String rua;
	
	@NotBlank 
	private String pais;
	
	///////////////////////// TOFORM //////////////////////////////////////
	public Endereco toForm(RepositoryEndereco RE) {
		Endereco endereco = new Endereco(null, estado, cidade, cep, rua, pais);
		RE.save(endereco);
		return endereco;
	}
    // SET E GET
	
	
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstado() {
		return estado;
	}

	public String getCidade() {
		return cidade;
	}

	public String getCep() {
		return cep;
	}

	public String getRua() {
		return rua;
	}

	public String getPais() {
		return pais;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}


}
