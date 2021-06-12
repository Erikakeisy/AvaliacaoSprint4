package LojaCadastro.Controller.Form;


import LojaCadastro.Modelo.Usuario;

import LojaCadastro.Repository.RepositoryUsuario;

public class UsuarioForm {
	
	private Long cpf;
	
	private String nome;
	
	
	public Usuario toForm(RepositoryUsuario RU) {
		return new Usuario(cpf,nome);
	}
	
	public Long getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
   
	



}
