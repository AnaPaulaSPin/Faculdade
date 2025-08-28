
package com.mycompany.sistemabr101;

public class Passeio extends Automovel {
    private int numPassageiros;
    
    public Passeio(int numPassageiros, String Placa, int ano){
        super(Placa, ano);
        this.numPassageiros = numPassageiros;
    }
    
    @Override
    public float calcularPedagio(){

        return 5 * this.getNumPassageiros();
    }

    public int getNumPassageiros() {
        return numPassageiros;
    }

    public void setNumPassageiros(int numPassageiros) {
        this.numPassageiros = numPassageiros;
    }
    
    
}
