
package com.mycompany.sistema_restaurante;

import java.util.ArrayList;

public class Pedido {
    private int numIden;
    private ArrayList<Prato> pratos;
    private Cliente cliente;
    private int horario;
    
    public Pedido(int numIden, Cliente cliente, int horario){
        this.numIden = numIden;
        this.cliente = cliente;
        this.horario = horario;
        this.pratos = new ArrayList<>();
    }
    
    public float calcularValorTotal(){
        float total = 0;
        for(Prato prat: pratos){
            total += prat.getValor();
        }
        
        return total;
    }
    
    public int somarTempo(){
        int tempo = 0;
        
        for(Prato prat: pratos){
            tempo+= prat.getTempoPreparo();
        }
        
        return tempo;
    }
    
    public boolean validarRapidez(Pedido p){
        if(p.somarTempo()<=15){
            return true;
        }else{
            return false;
        }
    }
    
    public ArrayList<Prato> getPratos(){
        return this.pratos;
    }
    public void addPratos(Prato prato){
        this.pratos.add(prato);
    }

    public int getNumIden() {
        return numIden;
    }

    public void setNumIden(int numIden) {
        this.numIden = numIden;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }
    
}
