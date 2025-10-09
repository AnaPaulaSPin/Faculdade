package com.mycompany.seguradora;

import java.util.ArrayList;

public class Empresa{
  private String nome;
  private ArrayList<Seguro> seguros;  
  
  public Empresa(String nome){
      this.nome = nome;
      this.seguros = new ArrayList<>();
  }
  public void imprimirListas(){
      for(Seguro seguro: seguros){
          seguro.imprimir();
          System.out.println();
      }
  }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Seguro> getSeguros() {
        return seguros;
    }

    public void addSeguros(Seguro seguro) {
        this.seguros.add(seguro);
    }
  
  
}
