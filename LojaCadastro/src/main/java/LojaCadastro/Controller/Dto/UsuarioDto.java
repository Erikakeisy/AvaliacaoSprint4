package LojaCadastro.Controller.Dto;

import java.util.List;
import java.util.stream.Collectors;
import LojaCadastro.Modelo.Usuario;

public class UsuarioDto {
	
	private Long cpf;
	
	private String nome;
	
	public UsuarioDto(Usuario usuario) {
		this.cpf = usuario.getCpf();
		this.nome = usuario.getNome();
	}
	
	public Long getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}
	
	public static List<UsuarioDto> converter(List<Usuario> usuarios){
		return usuarios.stream().map(UsuarioDto::new).collect(Collectors.toList());
	}
	

}
