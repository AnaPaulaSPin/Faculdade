package aplicacao.com.projeto.api.Repositorio;
import aplicacao.com.projeto.api.Modelo.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioProduto extends CrudRepository<Produto, Integer> {
    
}
