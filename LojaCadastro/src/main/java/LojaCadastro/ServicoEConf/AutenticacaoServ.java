package LojaCadastro.ServicoEConf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;

import LojaCadastro.Modelo.Cliente;
import LojaCadastro.Repository.RepositoryCliente;


@Service
public class AutenticacaoServ implements UserDetailsService {
	
	
	@Autowired
	private RepositoryCliente RC;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Cliente> cliente = RC.findByEmail(username);
		if(cliente.isPresent()) {
			return cliente.get();
		}
		throw new UsernameNotFoundException("DADOS INFORMADOS NÃO CADASTRADOS");
	}

}
