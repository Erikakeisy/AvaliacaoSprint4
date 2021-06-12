package LojaCadastro.Controller.Form;

import LojaCadastro.Modelo.Endereco;
import LojaCadastro.Repository.RepositoryEndereco;

public class EnderecoForm {
	
	private String estado;
	
	private String cidade;
	
	private String cep;
	
	private String rua;
	
	private String pais;
	
	public Endereco toForm(RepositoryEndereco RE) {
		return new Endereco(null, estado, cidade, cep, rua, pais);
	}


	public void setEstado(String estado) {
		this.estado = estado;
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
