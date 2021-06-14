package LojaCadastro.Controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.init.RepositoryPopulator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import LojaCadastro.Controller.Dto.PedidoDto;
import LojaCadastro.Controller.Form.PedidoForm;
import LojaCadastro.Modelo.Pedido;
import LojaCadastro.Repository.RepositoryPedido;
import LojaCadastro.Repository.RepositoryProduto;
import LojaCadastro.Repository.RepositoryUsuario;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;



	@Api(description = "AQUI VOCÊ PODE FAZER SEU PEDIDO!", tags = { "Pedidos" })
	@CrossOrigin(origins="*")
	@RestController
	@RequestMapping(value = "/pedido")

	public class PedidoController {
	    @Autowired 
	    RepositoryUsuario US;
	    @Autowired 
	    RepositoryPedido PE;
	    @Autowired
	    RepositoryProduto RP;

	    @GetMapping ("/pedido")
	    @ApiOperation(value="Método de listar pedidos")
	    public ResponseEntity<List<PedidoDto>> FindAll(){
	        List<Pedido> findList = PE.findAll();
	        PedidoDto DTO = new PedidoDto();
	        return ResponseEntity.ok().body(DTO.converter(findList));
	    }

	    @GetMapping("/{id}")
	    @ApiOperation(value="Busca de Pedido por Id")
	    public ResponseEntity<?> findOnePedido(@PathVariable long id){
	        try {
	            Pedido pedido = PE.getById(id);
	            PedidoDto DTO = new PedidoDto();
	            return ResponseEntity.ok().body(DTO.converter(pedido));
	        }
	        catch (EntityNotFoundException x){
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ID " + id + " NÃO FOI ENCONTRADO");
	        }
	    }

	    @PostMapping
	    @ApiOperation(value="Cadastro de Pedido")
	    public ResponseEntity<?> CadastrePedido(@RequestBody @Valid PedidoForm form, UriComponentsBuilder uri)
	    {
	            Pedido pedido = form.toForm(US,PE,RP);
	            URI ui = uri.path("/pedido/").buildAndExpand(pedido.getId()).toUri();
	            return ResponseEntity.created(ui).body(new PedidoDto().converter(pedido));


	    }
	}


