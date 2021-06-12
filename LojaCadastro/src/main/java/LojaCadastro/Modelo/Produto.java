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
	
	private String nomeProduto;
	
	private double preco;
	
	
	
	//CONSTRUCTOR
	public Produto(Long id, String nomeProduto, double preco) {
		//this.id = id;
		this.nomeProduto = nomeProduto;
		this.preco = preco;
		
	}
	

	// GET E SET 
	
	
	public String getNomeProduto() {
		return nomeProduto;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}


	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}





}
