package LojaCadastro.Modelo;


import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pedido {
	
	//INFORMAÇÕES DO PEDIDO
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Double valortotal;

	private LocalDateTime data = LocalDateTime.now();
	
	//CONSTRUCTOR
	
	public Pedido(Long id, Double valortotal, LocalDateTime data) {
		super();
		this.id = id;
		this.valortotal = valortotal;
		this.data = data;
	}
	
	
	//GET E SET
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValortotal() {
		return valortotal;
	}

	public void setValortotal(Double valortotal) {
		this.valortotal = valortotal;
	}
	
	public LocalDateTime getData() {
		return data;
	}


	public void setData(LocalDateTime data) {
		this.data = data;
	}





}
