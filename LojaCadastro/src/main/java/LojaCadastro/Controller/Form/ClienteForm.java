package LojaCadastro.Controller.Form;

import javax.validation.constraints.NotBlank;

import LojaCadastro.Modelo.Cliente;
import LojaCadastro.Repository.RepositoryCliente;

public class ClienteForm {
	
	@NotBlank
	private String email;
	@NotBlank
	private String senha;
	
	////////// TO FORM///////////////
	
	public Cliente toForm(RepositoryCliente RC) {
		Cliente cliente = new Cliente(email, senha);
		RC.save(cliente);
		return cliente;
	}
	
	
	////////////GET E SET////////////
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	
}
