package LojaCadastro.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import LojaCadastro.Controller.Dto.EnderecoDto;
import LojaCadastro.Modelo.Endereco;
import LojaCadastro.Repository.RepositoryEndereco;
import javax.persistence.EntityNotFoundException; 
import java.util.List;

Api(value="LOJINHA DA ERIKA")
@CrossOrigin(origins="*")
@RestController
@RequestMapping(value ="/endereco")
public class EnderecoController {

	    @Autowired
	    RepositoryEndereco RE;

	    @GetMapping ("/endereco")
	    @ApiOperation(value="Método que lista endereço")
	    public ResponseEntity<List<EnderecoDto>> FindAll(){
	        List<Endereco> findList = RE.findAll();
	        EnderecoDto DTO = new EnderecoDto();
	        return ResponseEntity.ok().body(DTO.converter(findList));
	    }
	    @GetMapping("/endereco{id}")
	    @ApiOperation(value=" Merodo que busca o endereço por Id")
	    public ResponseEntity<?> findOneProduto(@PathVariable long id){
	        try {
	            Endereco e = RE.getById(id);
	            EnderecoDto DTO = new EnderecoDto();
	            return ResponseEntity.ok().body(DTO.converter(e));
	        }
	        catch (EntityNotFoundException x){
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ID " + id + " não existe.");
	        }
	    }
	}

