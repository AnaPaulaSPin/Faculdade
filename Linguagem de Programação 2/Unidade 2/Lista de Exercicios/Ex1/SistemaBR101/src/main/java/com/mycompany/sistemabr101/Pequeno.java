
package com.mycompany.sistemabr101;


public class Pequeno extends Automovel {
    private String modelo;
    
    public Pequeno(String modelo, String Placa, int ano){
        super(Placa, ano);
        this.modelo = modelo;
    }
    
    @Override
    public float calcularPedagio(){  
        return 6;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
}
