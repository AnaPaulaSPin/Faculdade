import { Component, input} from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-primeiro-componente',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './primeiro-componente.html',
  styleUrl: './primeiro-componente.css',
})
export class PrimeiroComponente {
  name = "Ana"

}
