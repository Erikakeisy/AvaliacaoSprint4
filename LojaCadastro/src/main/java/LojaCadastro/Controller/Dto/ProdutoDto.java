package LojaCadastro.Controller.Dto;

import java.util.List;
import java.util.stream.Collectors;

import LojaCadastro.Modelo.Produto;


     ////////////// CLASSE DTO///////////
	public class ProdutoDto {
		
	////// INFOS/////////////////
	private Long id;

	private String descricao;
	
	private double precoUnitario;
	
	
	
    //// GET E SET
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public double getPrecoUnitario() {
		return precoUnitario;
	}


	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	

	
	
	////////////////CONSTRUCTOR////////////////
	public static ProdutoDto converter(Produto produto) {
		ProdutoDto pDto = new ProdutoDto();
		pDto.setDescricao(produto.getNomeProduto());
		pDto.setPrecoUnitario(produto.getPreco());
		return pDto;
		
	}

	public static List<ProdutoDto> converter(List<Produto> produto){
		return produto.stream().map(prod -> converter (prod)).collect(Collectors.toList());
	}

	
	

}
