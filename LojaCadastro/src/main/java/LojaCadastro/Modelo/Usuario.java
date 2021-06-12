package LojaCadastro.Modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;



@Entity
public class Usuario {
	
	//INFORMAÇÕES PESSOAIS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotEmpty @NotNull @NotBlank
	private Long id;
	@NotEmpty @NotNull @NotBlank
	private Long cpf;
	@NotEmpty @NotNull @NotBlank
	private String nome;
	@NotEmpty @NotNull @NotBlank
	private char sexo;
	@NotEmpty @NotNull @NotBlank
	private double salario;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuarioId")
	private List<Endereco> endereco;
	
	public Usuario() {
		
	}
	
	//GET E SET
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
	
	 ///CONSTRUCTOR///
			public Usuario( Long cpf, String nome) {
			this.cpf = cpf;
			this.nome = nome;
		}

}
