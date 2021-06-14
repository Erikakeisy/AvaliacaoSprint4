package LojaCadastro.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import LojaCadastro.Controller.Dto.UsuarioDto;
import LojaCadastro.Controller.Form.UsuarioForm;
import LojaCadastro.Modelo.Usuario;
import LojaCadastro.Repository.RepositoryUsuario;
import io.swagger.annotations.ApiOperation;

public class UsuarioController {
	
	@Autowired
	private RepositoryUsuario US;
	
	@RequestMapping("api/usuario")
	@ApiOperation(value = "Método para listar usuarios")
	public List<UsuarioDto> lista(){
		List<Usuario> usuarios = US.findAll();
		return UsuarioDto.converter(usuarios);
	}
	
	@PostMapping("api/usuario") 
	@ApiOperation(value = "Método para cadastrar usuarios")
	public ResponseEntity<UsuarioDto> cadastrar(@RequestBody  UsuarioForm form, UriComponentsBuilder uriBuilder){
		Usuario usuario = form.toForm(US); 
		US.save(usuario);
		URI uri = uriBuilder.path("/usuario").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(new UsuarioDto());
		
	}

}
