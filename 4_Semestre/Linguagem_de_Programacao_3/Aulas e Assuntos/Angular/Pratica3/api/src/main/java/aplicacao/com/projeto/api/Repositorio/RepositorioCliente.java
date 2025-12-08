package aplicacao.com.projeto.api.Repositorio;

import aplicacao.com.projeto.api.Modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioCliente extends JpaRepository<Cliente, Integer> {
    
}
