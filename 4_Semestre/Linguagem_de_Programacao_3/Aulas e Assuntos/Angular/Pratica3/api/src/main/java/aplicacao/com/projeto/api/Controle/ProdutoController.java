package aplicacao.com.projeto.api.Controle;

import aplicacao.com.projeto.api.Modelo.Produto;
import aplicacao.com.projeto.api.Repositorio.RepositorioProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private RepositorioProduto repositorioProduto;

    @GetMapping
    public List<Produto> listarProdutos() {
    List<Produto> produtos = new ArrayList<>();
    repositorioProduto.findAll().forEach(produtos::add);
    return produtos;
    }



    @PostMapping
    public Produto adicionarProduto(@RequestBody Produto produto) {
        return repositorioProduto.save(produto);
    }

    @GetMapping("/{id}")
    public Produto buscarProduto(@PathVariable Integer id) {
        return repositorioProduto.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String deletarProduto(@PathVariable Integer id) {
        repositorioProduto.deleteById(id);
        return "Produto deletado com sucesso!";
    }
}
