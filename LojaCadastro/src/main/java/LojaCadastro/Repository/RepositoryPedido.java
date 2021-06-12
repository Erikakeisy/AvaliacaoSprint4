package LojaCadastro.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import LojaCadastro.Modelo.Pedido;

@Repository
public interface RepositoryPedido extends JpaRepository<Pedido, Long> {
	

}
