package LojaCadastro.Controller;

import java.net.URI;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import LojaCadastro.Controller.Dto.UsuarioDto;
import LojaCadastro.Controller.Form.UsuarioForm;
import LojaCadastro.Modelo.Usuario;
import LojaCadastro.Repository.RepositoryUsuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@Api(description = "CADASTRO DE USUARIOS", tags = { "Usuario" })
public class UsuarioController {
	
	@Autowired
	private RepositoryUsuario US;
	
	
	@GetMapping("/usuario")
    public ResponseEntity<List<UsuarioDto>> FindAll(){
    List<Usuario> findList = US.findAll();
        UsuarioDto DTO = new UsuarioDto();
        return ResponseEntity.ok().body(DTO.converter(findList));
    }

    @GetMapping("/{id}")
    @ApiOperation(value="BUSCA PESSOAS POR ID")
    public ResponseEntity<?> findOnePessoa(@PathVariable long id){
        try {
        	Usuario usuario = US.getById(id);
            UsuarioDto DTO = new UsuarioDto();
            return ResponseEntity.ok().body(DTO.converter(usuario));
        }
        catch (EntityNotFoundException x){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ID " + id + " NÃO FOI ENCONTRADO");
        }
    }

    @PostMapping
    @ApiOperation(value="Cadastro de Pessoas")
    public ResponseEntity<?> CadastrePessoa(@RequestBody @Valid UsuarioForm form, UriComponentsBuilder uri)
    {
        try
        {
            Usuario usuario = form.toForm(US);
            URI ui = uri.path("/pessoa/").buildAndExpand(usuario.getId()).toUri();
            return ResponseEntity.created(ui).body(new UsuarioDto().converter(usuario));
        }
        catch (DataIntegrityViolationException SQL)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("DADOS JÁ CADASTRADOS");
        }
    }

}
