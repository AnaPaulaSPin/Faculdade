package aplicacao.com.projeto.api.Controle;

import aplicacao.com.projeto.api.Modelo.Carrinho;
import aplicacao.com.projeto.api.Repositorio.RepositorioCarrinho;
import aplicacao.com.projeto.api.Repositorio.RepositorioCliente;
import aplicacao.com.projeto.api.Repositorio.RepositorioProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    private RepositorioCarrinho repositorioCarrinho;

    @Autowired
    private RepositorioCliente repositorioCliente;

    @Autowired
    private RepositorioProduto repositorioProduto;

    @GetMapping
    public List<Carrinho> listarCarrinho() {
        return repositorioCarrinho.findAll();
    }

    @PostMapping
    public Carrinho adicionarAoCarrinho(@RequestParam Integer clienteId,
                                        @RequestParam Integer produtoId,
                                        @RequestParam Integer quantidade) {

        Carrinho carrinho = new Carrinho();
        carrinho.setCliente(repositorioCliente.findById(clienteId).orElse(null));
        carrinho.setProduto(repositorioProduto.findById(produtoId).orElse(null));
        carrinho.setQuantidade(quantidade);

        return repositorioCarrinho.save(carrinho);
    }

    @GetMapping("/{id}")
    public Carrinho buscarItem(@PathVariable Integer id) {
        return repositorioCarrinho.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String deletarItem(@PathVariable Integer id) {
        repositorioCarrinho.deleteById(id);
        return "Item do carrinho deletado com sucesso!";
    }
}
