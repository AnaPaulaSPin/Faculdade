import { HttpClientModule } from '@angular/common/http';
import { Component, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { ValidarService } from './Services/validar';
import { Cliente } from './Models/Cliente';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, FormsModule, HttpClientModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('api-front');
   email: string = '';
  senha: string = '';
  erro: string = '';

  constructor(private validarService: ValidarService) {}

  fazerLogin() {
    this.erro = '';
    cliente: Cliente;

    this.validarService.buscarClienteEmail(this.email, this.senha)
      .subscribe(cliente => {

        if (cliente) {
          console.log('Cliente encontrado:', cliente.nome);
          alert('Login realizado com sucesso!');
          // aqui você pode redirecionar para home, loja etc.
        } else {
          this.erro = 'Email ou senha inválidos.';
        }

      });
  }

}
