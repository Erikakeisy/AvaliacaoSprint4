package LojaCadastro.Controller.Form;


import javax.validation.constraints.NotBlank;
import com.sun.istack.NotNull;
import LojaCadastro.Modelo.Usuario;
import LojaCadastro.Repository.RepositoryUsuario;


/////////////// CLASSE FORM //////////////////
	public class UsuarioForm {
	@NotBlank
	private Long cpf;
	@NotBlank
	private String nome;
	 @NotNull
	private double salario;
	
///////////////// TO FORM /////////////////	
	public Usuario toForm(RepositoryUsuario RU) {
		Usuario usuario = new Usuario(cpf, nome,salario);
		RU.save(usuario);
		return usuario;
	}

///////// GET E SET ////////////////////

	public void setSalario(double salario) {
		this.salario = salario;
	}


	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public double getSalario() {
		return salario;
	}
   
	



}
