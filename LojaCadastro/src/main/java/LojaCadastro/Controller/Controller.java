package LojaCadastro.Controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import LojaCadastro.Controller.Dto.EnderecoDto;
import LojaCadastro.Controller.Dto.PedidoDto;
import LojaCadastro.Controller.Dto.ProdutoDto;
import LojaCadastro.Controller.Dto.UsuarioDto;
import LojaCadastro.Controller.Form.EnderecoForm;
import LojaCadastro.Controller.Form.PedidoForm;
import LojaCadastro.Controller.Form.ProdutoForm;
import LojaCadastro.Controller.Form.UsuarioForm;
import LojaCadastro.Modelo.Endereco;
import LojaCadastro.Modelo.Pedido;
import LojaCadastro.Modelo.Produto;
import LojaCadastro.Modelo.Usuario;
import LojaCadastro.Repository.RepositoryEndereco;
import LojaCadastro.Repository.RepositoryPedido;
import LojaCadastro.Repository.RepositoryProduto;


//import org.springframework.web.bind.annotation.*;
import java.net.URI;
import LojaCadastro.Repository.RepositoryUsuario;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api")
public class Controller {
	
	@Autowired
	private RepositoryUsuario US;
	@Autowired
	private RepositoryProduto RP;
	@Autowired
	private RepositoryEndereco RE;
	
	@Autowired
	private RepositoryPedido PE;
	
	
	////////////////////USUARIO//////////////////////////
	@RequestMapping("/usuario")
	@ApiOperation(value = "Método para listar usuarios")
	public List<UsuarioDto> lista(){
		List<Usuario> usuarios = US.findAll();
		return UsuarioDto.converter(usuarios);
	}
	
	@PostMapping("/usuario") 
	@ApiOperation(value = "Método para cadastrar usuarios")
	public ResponseEntity<UsuarioDto> cadastrar(@RequestBody  UsuarioForm form, UriComponentsBuilder uriBuilder){
		Usuario usuario = form.toForm(US); 
		US.save(usuario);
		URI uri = uriBuilder.path("/usuario").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(new UsuarioDto());
		
	}
	
	///////////////////PRODUTO////////////////////////////
	
	@RequestMapping("/produto")
	@ApiOperation(value = "Método para visualizar produtos")
	public List<ProdutoDto> listar (){
	List<Produto> produto = RP.findAll();
	return ProdutoDto.converter(produto);
	}
	

	@PostMapping ("/produto")
	@ApiOperation(value = "Método para cadastrar produtos")
	public ResponseEntity<ProdutoDto> cadastrar(@RequestBody  ProdutoForm form, UriComponentsBuilder uriBuilder){
		Produto produto = form.toForm(RP);
		RP.save(produto);
		URI uri = uriBuilder.path("/produto").buildAndExpand(produto.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProdutoDto());
	}
	
	

	//////////////////////ENDEREÇO////////////////////////
	
	@GetMapping("/endereco")
	@ApiOperation(value = "Método para visualizar endereço")
	public List<EnderecoDto> listar1(){
	  List<Endereco> endereco = RE.findAll();
	  return EnderecoDto.converter(endereco);
	}
	
	@PostMapping("/endereco") 
	@ApiOperation(value = "Método para cadastrar endereco")
	public ResponseEntity<EnderecoDto> cadastrar(@RequestBody EnderecoForm form, UriComponentsBuilder uriBuilder){
		Endereco endereco = form.toForm(RE); 
		RE.save(endereco);
		URI uri = uriBuilder.path("/endereco").buildAndExpand(endereco.getId()).toUri();
		return ResponseEntity.created(uri).body(new EnderecoDto());
	}
	
	
	/////////////////PEDIDO/////////////////////////////
	
	@RequestMapping("/pedido")
	@ApiOperation(value = "Método para pedidos")
	public List<PedidoDto> listar2(){
		List<Pedido> pedidos = PE.findAll();
		return PedidoDto.converter(pedidos);
	}
	
	@PostMapping("/pedido") 
	@ApiOperation(value = "Método para pedidos")
	public ResponseEntity<PedidoDto> cadastrar(@RequestBody  PedidoForm form, UriComponentsBuilder uriBuilder){
		Pedido pedidos = form.toForm(US, PE, RP); 
		URI uri = uriBuilder.path("/pedido").buildAndExpand(pedidos.getId()).toUri();
		new PedidoDto();
		return ResponseEntity.created(uri).body(PedidoDto.converter(pedidos));
		
	}

}
	
	
	
	
	
	  
 

	

	
	
	
		

	 


