import { Produto } from "./Produto";
import { Cliente } from "./Cliente";

export class Carrinho {
  id!: number;
  cliente!: Cliente;
  produto!: Produto;
  quantidade!: number;
}
