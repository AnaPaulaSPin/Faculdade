
package com.mycompany.companhiaenergia;

import java.util.ArrayList;

public abstract class Cliente {
    protected String nome;
    protected ArrayList<Consumo> consumos;

    public Cliente(String nome) {
        this.nome = nome;
        this.consumos = new ArrayList<>();
    }
    
    public abstract float calcularConta(Consumo consumo);
    
    public float gastoTotal(){
        float total = 0;
        for(Consumo cons: consumos){
            total+= this.calcularConta(cons);
        }
        return total+1;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Consumo> getConsumos() {
        return consumos;
    }

    public void addConsumos(Consumo consumo) {
        this.consumos.add(consumo);
    }
    
    
}

