package LojaCadastro.ServicoEConf;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.filter.OncePerRequestFilter;

import LojaCadastro.Modelo.Cliente;
import LojaCadastro.Repository.RepositoryCliente;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.NoSuchElementException;



		public class FiltroToken extends OncePerRequestFilter {
	
       
	    private ServicoToken TS;
	    private RepositoryCliente RC;


		public FiltroToken(ServicoToken tS, RepositoryCliente rC) {
			super();
			TS = tS;
			RC = rC;
		}

		@Override
	    protected void doFilterInternal
	            (HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,FilterChain filterChain)
	            throws ServletException, IOException {
	        String token = FindToken(httpServletRequest);
	        boolean valid = TS.isValidToken(token);
	        if (valid) {
	            authenticate(token);
	        }
	        filterChain.doFilter(httpServletRequest, httpServletResponse);
	    }

	    private String FindToken(HttpServletRequest httpServletRequest) {
	        String token = httpServletRequest.getHeader("Authorization");
	        if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
	            return null;
	        }
	        return token.substring(8, token.length());
	    }

	    private void authenticate (String token){
	        Long id = TS.getId(token);
	        try {
	            Cliente cliente = RC.findById(id).get();
	            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken
	                    (cliente.getEmail(), null, cliente.getAuthorities());
	            SecurityContextHolder.getContext().setAuthentication(authentication);
	        }
	        catch (NoSuchElementException e) {
	            System.out.println("ACESSO NEGADO" + "TOKEN INVÁLIDO");
	        }
	    
	}

	}
	
	
	
	


