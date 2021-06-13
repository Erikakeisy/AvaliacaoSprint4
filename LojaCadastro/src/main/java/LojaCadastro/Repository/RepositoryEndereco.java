package LojaCadastro.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import LojaCadastro.Modelo.Endereco;
//import LojaCadastro.Modelo.Usuario;
@Repository
public interface RepositoryEndereco extends JpaRepository<Endereco, Long> {

	
		
	
	 
		

}
