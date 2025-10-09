
package com.mycompany.companhiaenergia;

public class Consumo {
    private int kw;
    private String mes;

    public Consumo(int kw, String mes) {
        this.kw = kw;
        this.mes = mes;
    }

    public int getKw() {
        return kw;
    }

    public void setKw(int kw) {
        this.kw = kw;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
    
    
}
