package LojaCadastro.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.google.common.base.Optional;

import LojaCadastro.Modelo.Cliente;

public interface RepositoryCliente extends JpaRepository<Cliente, Long > {
	 Optional<Cliente> findByEmail(String email);
}
