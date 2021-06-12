package LojaCadastro.Controller.Dto;

import java.util.List;
import java.util.stream.Collectors;

import LojaCadastro.Modelo.Produto;



public class ProdutoDto {
	
	private Long id;

	private String nomeProduto;
	
	private double preco;
	
	
	public ProdutoDto(Produto produto) {
		//this.id = produto.getId();
		this.nomeProduto = produto.getNomeProduto();
		this.preco = produto.getPreco();
		
	}
	
	public Long getId() {
		return id;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}

	public double getPreco() {
		return preco;
	}

	public static List<ProdutoDto> converter(List<Produto> produto){
		return produto.stream().map(ProdutoDto::new).collect(Collectors.toList());
	}
	

}
