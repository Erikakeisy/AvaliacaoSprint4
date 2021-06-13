package LojaCadastro.Controller.Form;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import LojaCadastro.Modelo.Pedido;
import LojaCadastro.Modelo.Produto;
import LojaCadastro.Repository.RepositoryPedido;
import LojaCadastro.Repository.RepositoryProduto;
import LojaCadastro.Repository.RepositoryUsuario;

//////////////////CLASSE FORM////////////////
   public class PedidoForm {
	
	@NotEmpty @NotNull
	private List<Long> idProduto;
	
	//SETTT
	
	public void setIdProduto(List<Long> idProduto) {
		this.idProduto = idProduto;
	}
	public List<Long> getIdProduto() {
		return idProduto;
	}
	
	
	//SOMA///
	
	public Pedido toForm(RepositoryUsuario US, RepositoryPedido PE, RepositoryProduto RP) {
		double total = 0.0;
		List<Produto> produtos = new ArrayList<Produto>();
		for(Long idprod : idProduto)
		{
			Produto prod = RP.getById(idprod);
			total += prod.getPreco();
			produtos.add(prod);
		}
		Pedido pedido = new Pedido(null, produtos, total);
		PE.save(pedido);
		return pedido;
	}


}
