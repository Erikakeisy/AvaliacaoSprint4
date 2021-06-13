package LojaCadastro.Controller.Dto;

import java.util.List;
import java.util.stream.Collectors;
import LojaCadastro.Modelo.Usuario;


//////////////CLASE DTO///////////////
	public class UsuarioDto {
	
	private Long cpf;
	
	private String nome;

/////////GET E SET//////////
	
	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
/////////////CONSTRUCTOR////////////////	
	public static UsuarioDto converter(Usuario u) {
		UsuarioDto dUs = new UsuarioDto();
		dUs.setNome(u.getNome());
		dUs.setCpf(u.getCpf());
		return dUs;
	}
	
	public static List<UsuarioDto> converter(List<Usuario> usuario){
		return usuario.stream().map(us -> converter (us)).collect(Collectors.toList());
	}


}
