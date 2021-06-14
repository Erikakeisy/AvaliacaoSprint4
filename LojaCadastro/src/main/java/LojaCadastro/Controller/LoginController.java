package LojaCadastro.Controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import LojaCadastro.Controller.Dto.ClienteDto;
import LojaCadastro.Controller.Form.ClienteForm;
import LojaCadastro.Modelo.Cliente;
import LojaCadastro.Repository.RepositoryCliente;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;



@Api(value="LOJINHA DA ERIKA")
@CrossOrigin(origins="*")
@RequestMapping("/login")
@RestController
public class LoginController {
	
	@Autowired
    private RepositoryCliente RC;

    @PostMapping
    @ApiOperation(value="Login")
    public ResponseEntity<?> add(@RequestBody @Valid ClienteForm form, UriComponentsBuilder uriBuilder){
        Cliente login = form.toForm(RC);
        URI uri = uriBuilder.path("/user/{id}").buildAndExpand(login.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClienteDto().converter(login));
    }
    
    @GetMapping("/{id}")
    @ApiOperation(value=" Métod que busca por  Id")
    public ResponseEntity<?> findOneCliente(@PathVariable long id) {
            Cliente cliente = RC.getById(id);
            ClienteDto dto = new ClienteDto();
            if (cliente != null) {
                return ResponseEntity.ok().body(dto.converter(cliente));
            }
            return ResponseEntity.badRequest().build();
         
    }
    
    @GetMapping
    @ApiOperation(value=" Metodo da lista completa")
    public ResponseEntity<List<ClienteDto>> findAllCliente(){
        List<Cliente> login = RC.findAll();
        ClienteDto dto = new ClienteDto();
        return ResponseEntity.ok().body(dto.converter(login));
    }

	
		
	}


