package com.mycompany.pet_e_dono.com.mycompany.pet_e_dono;
public class Dono {
    private String name;
    private int telefone;
    private int mordidas;

    public Dono(String nome, int tel){
        this.name = nome;
        this.telefone = tel;
        this.mordidas = 0;
    }
    
    public void mostrarMordidas(){
        System.out.println("Mordidas: " + this.getMordidas());
        
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public int getMordidas() {
        return mordidas;
    }

    public void setMordidas(int mordidas) {
        this.mordidas = mordidas;
    }
    
    
}

