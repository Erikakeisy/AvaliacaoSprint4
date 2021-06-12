package LojaCadastro.Controller.Dto;

import java.util.List;

public class PedidoDto {
	
	private Long idUsuario;
	private List<Long> idProduto;
	
	public Long getIdUsuario() {
		return idUsuario;
	}
	public List<Long> getIdProduto() {
		return idProduto;
	}
	
	

}
