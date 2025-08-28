
package com.mycompany.companhiaenergia;

import java.util.ArrayList;

public class Companhia {
    private String nome;
    private ArrayList<Cliente> clientes;

    public Companhia(String nome) {
        this.nome = nome;
        this.clientes = new ArrayList<>();
    }
    
    public float RendaTotal(){
        float total = 0;
        for(Cliente cli: clientes){
            total+= cli.gastoTotal();
        }
        return total;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    
}
