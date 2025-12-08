import { Cliente } from './../Models/Cliente';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ValidarService {
  private apiUrl = 'http://localhost:8080/cliente'; // endpoint do servidor

  constructor(private http: HttpClient) {}

  // GET - buscar clientes
  getUsuarios(): Observable<Cliente[]> {
    return this.http.get<Cliente[]>(this.apiUrl);
  }

  // POST - criar um novo cliente
  criarUsuario(cliente: Cliente): Observable<Cliente> {
    return this.http.post<Cliente>(this.apiUrl, cliente);
  }

  //Faz uma busca e retorna o cliente que fez o login:
  buscarClienteEmail(email: string, senha: string): Observable<Cliente | null> {
  return this.getUsuarios().pipe(
    map(clientes => {
      const clienteEncontrado = clientes.find(
        c => c.email === email && c.senha === senha
      );
      return clienteEncontrado ?? null;
    })
  );
}


}
