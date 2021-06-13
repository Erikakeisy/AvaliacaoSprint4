package LojaCadastro.Controller.Form;


import javax.validation.constraints.NotBlank;
import com.sun.istack.NotNull;
import LojaCadastro.Modelo.Produto;
import LojaCadastro.Repository.RepositoryProduto;


//////////////CLASSE FORM///////////////
	public class ProdutoForm {
	
	@NotBlank
	private String descricao;
	@NotNull
	private double precoUnitario;
	
////////////// TO FORM /////////////////	
	public Produto toForm(RepositoryProduto RP) {
		Produto produto = new Produto(null, descricao, precoUnitario);
		RP.save(produto);
		return produto;
	}
	
//////////////// GET E SET /////////////////
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}


	public String getDescricao() {
		return descricao;
	}


	public double getPrecoUnitario() {
		return precoUnitario;
	}
	



}
