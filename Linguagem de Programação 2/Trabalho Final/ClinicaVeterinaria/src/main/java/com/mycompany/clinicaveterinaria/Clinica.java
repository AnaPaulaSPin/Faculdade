package com.mycompany.clinicaveterinaria;

import java.util.ArrayList;

public class Clinica {
    private String nome;
    private ArrayList<Veterinario> veterinarios;
    private ArrayList<Animal> animais;
    private ArrayList<Consulta> consultas;
    
    public Clinica(String nome){
        this.nome = nome;
        this.animais = new ArrayList<>();
        this.consultas = new ArrayList<>();
        this.veterinarios = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Veterinario> getVeterinarios() {
        return veterinarios;
    }

    public void addVeterinarios(Veterinario veterinario) {
        this.veterinarios.add(veterinario);
    }

    public ArrayList<Animal> getAnimais() {
        return animais;
    }

    public void addAnimais(Animal animal) {
        this.animais.add(animal);
    }

    public ArrayList<Consulta> getConsultas() {
        return consultas;
    }

    public void addConsultas(Consulta consultas) {
        this.consultas.add(consultas);
    }
    
}
