package com.mycompany.sistemacinema;

import java.util.ArrayList;
 
class Cinema
{
    private String nome;
    private ArrayList<Sala> salas;
    
    public Cinema(String nome){
        this.nome = nome;
        this.salas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Sala> getSalas() {
        return salas;
    }

    public void addSalas(Sala sala) {
        this.salas.add(sala);
    }
    
    
}

