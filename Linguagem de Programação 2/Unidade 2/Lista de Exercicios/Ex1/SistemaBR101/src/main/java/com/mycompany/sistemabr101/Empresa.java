
package com.mycompany.sistemabr101;

import java.util.ArrayList;

public class Empresa {
    private String nome;
    private ArrayList<Contrato> clientes;

    public Empresa(String nome) {
        this.nome = nome;
        this.clientes = new ArrayList<>();
    }
    
    public Contrato ClienteVipMes(int n){
        float maior = 0; Contrato nome = null;
        for(Contrato cont: clientes){
            if(cont.CalcularFatura(n) > maior){
                maior = cont.CalcularFatura(n);
                nome = cont;
            }
        }
        return nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Contrato> getClientes() {
        return clientes;
    }

    public void addClientes(Contrato cliente) {
        this.clientes.add(cliente);
    }
    
    
    
    
    
}
