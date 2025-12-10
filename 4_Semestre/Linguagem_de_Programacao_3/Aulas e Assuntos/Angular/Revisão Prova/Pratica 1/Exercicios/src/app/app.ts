import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { AdicionarGeneros } from './Genero-Musical/adicionar-generos/adicionar-generos';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet,AdicionarGeneros],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('Exercicios');
}
