package LojaCadastro.Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco {
	
//INFORMAÇÕES ENDEREÇO
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String estado;

	private String cidade;
	
	private String cep;
	
	private String rua;
	
	private String pais;
	
	
// CONSTRUCTOR
	public Endereco(Long id , String estado, String cidade, String cep, String rua, String pais) {
		super();
		this.id = id;
		this.estado = estado;
		this.cidade = cidade;
		this.cep = cep;
		this.rua = rua;
		this.pais = pais;
	}
	
		
//GET E SET	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

}
