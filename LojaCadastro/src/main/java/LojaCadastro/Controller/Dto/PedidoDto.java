package LojaCadastro.Controller.Dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import LojaCadastro.Modelo.Pedido;

////////////// CLASSE STO////////////
public class PedidoDto {
	
//////////// INFOS///////////////
	private Long id;
	private double valorTotal;
	private LocalDateTime data = LocalDateTime.now();
	private List<ProdutoDto> produtoDto;
	
	
/////////////GET SET///////////////////
	
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public List<ProdutoDto> getProdutoDto() {
		return produtoDto;
	}
	public void setProdutoDto(List<ProdutoDto> produtoDto) {
		this.produtoDto = produtoDto;
	}
	
	
////////////////////////////CONSTRUCTOR/////////////////////
	
	public static PedidoDto converter(Pedido p) {
		PedidoDto DTO = new PedidoDto();
		ProdutoDto dProd1 = new ProdutoDto();
		DTO.setValorTotal(p.getTotal());
		DTO.setData(p.getData());
		DTO.setProdutoDto(dProd1.converter(p.getProduto()));
		return DTO;

	}
	
	public static List<PedidoDto> converter(List<Pedido> pedido){
		return pedido.stream().map(ped -> converter (ped)).collect(Collectors.toList());
	}

	

}
