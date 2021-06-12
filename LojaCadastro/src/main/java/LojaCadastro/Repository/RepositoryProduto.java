package LojaCadastro.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import LojaCadastro.Modelo.Produto;

@Repository
public interface RepositoryProduto extends JpaRepository<Produto, Long> {

}
