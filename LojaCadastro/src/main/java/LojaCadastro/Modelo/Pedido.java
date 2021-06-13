package LojaCadastro.Modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Pedido {
	
	//INFORMAÇÕES DO PEDIDO
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private double total;
	
	private LocalDateTime data;
	


	//CONSTRUCTOR
	
		public Pedido() {
		}
		

	public Pedido(double total, LocalDateTime data, List<Produto> produto) {
		super();
		this.total = total;
		this.data = data;
		this.produto = produto;
	}


	// MANY TO MANY
		
	@ManyToMany (cascade = CascadeType.ALL)
	@JoinTable(name = "pedidos")
	private List<Produto> produto = new ArrayList<Produto>();
	public Pedido(Usuario usuario, List<Produto> listaProdutos, double total) {
		
	}
	


	//GET E SET
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public LocalDateTime getData() {
		return data;
	}


	public void setData(LocalDateTime data) {
		this.data = data;
	}


	public List<Produto> getProduto() {
		return produto;
	}


	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}




	




}
