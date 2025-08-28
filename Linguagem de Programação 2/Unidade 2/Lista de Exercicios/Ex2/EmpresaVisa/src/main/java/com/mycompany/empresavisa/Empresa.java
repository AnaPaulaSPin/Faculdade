
package com.mycompany.empresavisa;

import java.util.ArrayList;

public class Empresa {
    private String nome;
    private ArrayList<Cliente> clientes;
    
    public Empresa(String nome){
        this.nome = nome;
        this.clientes = new ArrayList<>();
    }
    
    public String MaiorPontos(){
        String nome = null; float maior = 0;
        for(Cliente cli: clientes){
            if(maior < cli.totalPontos()){
                maior = cli.totalPontos();
                nome = cli.getNome();
            }
        }
        return nome;
    }
    
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void addClientes(Cliente cliente){
        this.clientes.add(cliente);
    }
}
