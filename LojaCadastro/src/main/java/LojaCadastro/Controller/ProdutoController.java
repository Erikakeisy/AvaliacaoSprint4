package LojaCadastro.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import LojaCadastro.Controller.Dto.ProdutoDto;
import LojaCadastro.Controller.Form.ProdutoForm;
import LojaCadastro.Modelo.Produto;
import LojaCadastro.Repository.RepositoryProduto;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;






	@Api(description = "BUSCAR E CADASTRAR PRODUTO", tags = { "Produto" })
	@CrossOrigin(origins="*")
	@RestController
	@RequestMapping(value ="/produto")
	public class ProdutoController {

	    @Autowired
	   RepositoryProduto RP;

	    @GetMapping("/produto")
	    @ApiOperation(value="Método de Listagem Completa")
	    public ResponseEntity<List<ProdutoDto>> FindAll(){
	        List<Produto> findList = RP.findAll();
	        ProdutoDto dto = new ProdutoDto();
	        return ResponseEntity.ok().body(dto.converter(findList));
	    }
	    @GetMapping("/{id}")
	    @ApiOperation(value="Busca de Produto por Id")
	    public ResponseEntity<?> findOneProduto(@PathVariable long id){
	        try {
	            Produto p = RP.getById(id);
	            ProdutoDto dto = new ProdutoDto();
	            return ResponseEntity.ok().body(dto.converter(p));
	        }
	        catch (EntityNotFoundException x){
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ID " + id + " não existe.");
	        }
	    }
	    @PostMapping
	    @ApiOperation(value="Cadastro de Produtos")
	    public ResponseEntity<?> CadastreProduto(@RequestBody @Valid ProdutoForm form, UriComponentsBuilder uri)
	    {
	        try
	        {
	            Produto produto = form.toForm(RP);
	            URI ui = uri.path("/produto/").buildAndExpand(produto.getId()).toUri();
	            return ResponseEntity.created(ui).body(new ProdutoDto().converter(produto));
	        }
	        catch (DataIntegrityViolationException SQL)
	        {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ESSES DADOS JÁ FORAM CADASTRADOS");
	        }
	    }
	}

