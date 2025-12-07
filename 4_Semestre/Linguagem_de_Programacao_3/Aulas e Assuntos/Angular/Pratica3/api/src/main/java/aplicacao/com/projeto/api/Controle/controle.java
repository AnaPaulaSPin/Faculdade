package aplicacao.com.projeto.api.Controle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controle {
    @GetMapping("/")
    public String teste(){
        return "Hello World!";
    }
}
