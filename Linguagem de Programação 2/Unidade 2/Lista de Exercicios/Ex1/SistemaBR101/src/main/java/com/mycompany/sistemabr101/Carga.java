
package com.mycompany.sistemabr101;

public class Carga extends Automovel {
    private int pesoMax;
    
    public Carga(int pesoMax, String Placa, int ano){
        super(Placa, ano);
        this.pesoMax = pesoMax;
        }
    
    @Override
    public float calcularPedagio(){
       return 2 * this.getPesoMax();
    }
    

    public int getPesoMax() {
        return pesoMax;
    }

    public void setPesoMax(int pesoMax) {
        this.pesoMax = pesoMax;
    }
    
}
