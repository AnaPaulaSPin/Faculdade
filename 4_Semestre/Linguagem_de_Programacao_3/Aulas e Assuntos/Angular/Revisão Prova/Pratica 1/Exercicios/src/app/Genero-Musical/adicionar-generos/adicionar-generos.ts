import { Genero } from './../Model/Genero';
import {ChangeDetectionStrategy, Component} from '@angular/core';
import {MatSelectModule} from '@angular/material/select';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatIconModule} from '@angular/material/icon';
import {MatDividerModule} from '@angular/material/divider';
import {MatButtonModule} from '@angular/material/button';
import {MatListModule} from '@angular/material/list';
import { NgIf,NgFor } from '@angular/common';
import { FormControl, FormGroup, ReactiveFormsModule,  } from '@angular/forms';

@Component({
  selector: 'app-adicionar-generos',
  imports: [MatSelectModule, MatInputModule, MatFormFieldModule, MatButtonModule, MatDividerModule, MatIconModule, NgIf,MatListModule,NgFor,ReactiveFormsModule],
  templateUrl: './adicionar-generos.html',
  styleUrl: './adicionar-generos.css',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class AdicionarGeneros {
  aparecerCadastrar = false
  aparecerdeletar = false
  aparecerListar = false

  selecionado = 0
  form = new FormGroup({
  nome: new FormControl(''),      // campo nome
  artista: new FormControl('')  // campo categoria
});



  generos: Genero[] = [
    {id:0, nome: 'Rock', artistas:30},
    {id:1, nome:'Kpop', artistas:50},
    {id:2, nome:'Pop', artistas:100}

  ];

  AtivarCadastrar(){
    this.aparecerdeletar = false
    this.aparecerListar = false
    this.aparecerCadastrar = true
  }

  AtivarDeletar(){
    this.aparecerCadastrar = false
    this.aparecerListar = false
    this.aparecerdeletar = true
  }

  AtivarListar(){
    this.aparecerCadastrar = false
    this.aparecerdeletar = false
    this.aparecerListar = true
  }

  Deletar(){
    console.log(this.selecionado)
    this.generos = this.generos.filter((produto) => produto.id !== this.selecionado)

  }

  Cadastrar(){
    this.generos.push({id:this.generos.length++,nome:String(this.form.value.nome),artistas: Number(this.form.value.artista) })

  }




}
