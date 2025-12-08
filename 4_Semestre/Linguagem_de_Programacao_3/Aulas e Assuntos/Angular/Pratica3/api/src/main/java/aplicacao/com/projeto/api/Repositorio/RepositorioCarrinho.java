package aplicacao.com.projeto.api.Repositorio;

import aplicacao.com.projeto.api.Modelo.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioCarrinho extends JpaRepository<Carrinho, Integer> {
    // Métodos personalizados se precisar
    // List<Carrinho> findByClienteId(Integer clienteId);
}
