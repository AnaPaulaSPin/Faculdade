
package com.mycompany.sistemacinema;

public class Sala3D extends Sala {
    private String equipamento;
    
    public Sala3D(int numero, int capacidade,String equipamento){
        super(numero, capacidade);
        this.equipamento = equipamento;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }
    
    
}
