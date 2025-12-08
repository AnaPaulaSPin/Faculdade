package aplicacao.com.projeto.api.Controle;

import aplicacao.com.projeto.api.Modelo.Cliente;
import aplicacao.com.projeto.api.Repositorio.RepositorioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private RepositorioCliente repositorioCliente;

    @GetMapping
    public List<Cliente> listarClientes() {
        return repositorioCliente.findAll();
    }

    @PostMapping
    public Cliente adicionarCliente(@RequestBody Cliente cliente) {
        return repositorioCliente.save(cliente);
    }

    @GetMapping("/{id}")
    public Cliente buscarCliente(@PathVariable Integer id) {
        return repositorioCliente.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String deletarCliente(@PathVariable Integer id) {
        repositorioCliente.deleteById(id);
        return "Cliente deletado com sucesso!";
    }
}
