package com.mycompany.pet_e_dono;

import com.mycompany.pet_e_dono.com.mycompany.pet_e_dono.Dono;

public class Pet {
    private String nome;
    private String tipo;
    private Dono dono;
    
    public Pet(String name, String tipo, Dono dono){
        this.nome = name;
        this.tipo = tipo;
        this.dono = dono;
    }
    
    public void morder(){
        int morder = dono.getMordidas();
        morder++;
        dono.setMordidas(morder);
    }
    
    public void mostrarDono(){
        System.out.println("Nome do Pet: " + this.getNome());
        System.out.println("Tipo: " + this.getTipo());
        System.out.println("Seu Dono: " + dono.getName());
        System.out.println("Numero do Dono: " + dono.getTelefone());
    }

    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Dono getDono() {
        return dono;
    }
    public void setDono(Dono dono) {
        this.dono = dono;
    }
    
    
}
