package LojaCadastro.Controller;



import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import LojaCadastro.Controller.Dto.TokenDto;
import LojaCadastro.Controller.Form.LoginForm;
import LojaCadastro.ServicoEConf.ServicoToken;

import javax.validation.Valid;

	@Api(value="LOJINHA DA ERIKA",description = "AUTENTICAÇÃO")
	@CrossOrigin(origins="*")
	@RestController
	@RequestMapping("/autenticacao")
	public class SegurancaController {
	    @Autowired
	    private AuthenticationManager AM;

	    @Autowired
	    private ServicoToken servToken;

	    @PostMapping
	    @ApiOperation(value="Token")
	    public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginForm form) {
	        UsernamePasswordAuthenticationToken dadosLogin = form.converter();
	        try {
	            Authentication authentication = AM.authenticate(dadosLogin);
	            String token = servToken.gerarToken(authentication);
	            return ResponseEntity.ok(new TokenDto(token, "Bearer"));
	        } 
	        catch (AuthenticationException e) {
	            return ResponseEntity.badRequest().build();
	        }
	    }
	}

	    

