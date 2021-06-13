package LojaCadastro.Modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;



@Entity
public class Usuario {
	
	//INFORMAÇÕES PESSOAIS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	private Long cpf;
	
	
	private String nome;
	
	private char sexo;
	
	private double salario;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuarioId")
	private List<Endereco> endereco;
	
	/// CONSTRUCTOR ////
	
	public Usuario() {
		
	}

	public Usuario(Long cpf, String nome, double salario) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.salario = salario;
	}


	//GET E SET
	
	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
}
			
	  
