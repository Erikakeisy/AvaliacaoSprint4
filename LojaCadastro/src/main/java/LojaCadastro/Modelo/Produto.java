package LojaCadastro.Modelo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Produto {
	
	//INFORMAÇÃO PRODUTO
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String descricao;
	
	private double precoUnitario;
	
	
	
	//CONSTRUCTOR
	 public Produto() {
		
	 }
	
	public Produto(Long id, String descricao, double precoUnitario) {
		
		this.descricao = descricao;
		this.precoUnitario = precoUnitario;
		
	}
	
	// GET E SET 
	
	
	public String getNomeProduto() {
		return descricao;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public double getPreco() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}





}
