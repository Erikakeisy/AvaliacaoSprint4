package LojaCadastro.Controller;

import java.util.List;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import LojaCadastro.Controller.Dto.EnderecoDto;
import LojaCadastro.Modelo.Endereco;
import LojaCadastro.Repository.RepositoryEndereco;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(description = "CONTROLADOR DE ENDEREÇO", tags = { "Endereco" })
@CrossOrigin(origins="*")
@RestController
@RequestMapping(value ="/endereco")
public class EnderecoController {
	
	 @Autowired
	    private RepositoryEndereco RE;
	 
	
	    @GetMapping
	    @ApiOperation(value = "Metodo que busca todos os endereços.")
	    public ResponseEntity<?> FindAllEndereco() {
	        List<Endereco> endereco = RE.findAll();
	        EnderecoDto DTO = new EnderecoDto();
	        return ResponseEntity.ok().body(DTO.converter(endereco));
	    }
	    @ApiOperation(value = "Metodo que busca um endereço pelo ID.")
	    @GetMapping("/{id}")
	    public ResponseEntity<?> FindOneEndereco(@PathVariable Long id) {
	        try {
	            Endereco endereco = RE.getById(id);
	            EnderecoDto DTO = new EnderecoDto();
	            return ResponseEntity.ok().body(DTO.converter(endereco));
	        } catch (EntityNotFoundException e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ENDEREÇO ID: " + id + ", NÃO FOI ENCONTRADO");
	        }

	    }

}
