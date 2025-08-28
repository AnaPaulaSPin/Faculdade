
package com.mycompany.sistemacinema;

public class SalaVip extends Sala{
    private int horario;
    
    public SalaVip(int numero, int capacidade, int horario){
        super(numero,capacidade);
        this.horario = horario;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }
    
    
}
