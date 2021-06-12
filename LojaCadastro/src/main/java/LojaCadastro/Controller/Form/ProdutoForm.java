package LojaCadastro.Controller.Form;


import LojaCadastro.Modelo.Produto;
import LojaCadastro.Repository.RepositoryProduto;

public class ProdutoForm {
	
	private Long id;
	
	private String nomeProduto;
	
	private double preco;
	
	public Produto toForm(RepositoryProduto RP) {
		return new Produto(id,nomeProduto,preco);
	}
	
	public void setId(Long id) {
		this.id = id;
	}


	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}



}
