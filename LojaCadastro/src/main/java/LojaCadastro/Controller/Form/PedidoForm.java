package LojaCadastro.Controller.Form;

import java.util.List;

public class PedidoForm {
	
	private Long idUsuario;
	private List<Long> idProduto;
	
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public void setIdProduto(List<Long> idProduto) {
		this.idProduto = idProduto;
	}
	

}
