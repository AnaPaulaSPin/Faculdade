
package com.mycompany.empresavisa;

import java.util.ArrayList;

public class Adm {
    private String nome;
    private ArrayList<Cliente> clientes;

    public Adm(String nome) {
        this.nome = nome;
        this.clientes = new ArrayList<>();
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

    public void addClientes(Cliente cliente) {
        this.clientes.add(cliente);
    }
    
    
}
