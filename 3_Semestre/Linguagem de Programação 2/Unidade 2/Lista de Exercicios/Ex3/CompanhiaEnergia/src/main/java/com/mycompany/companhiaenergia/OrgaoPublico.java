
package com.mycompany.companhiaenergia;

public class OrgaoPublico extends Cliente {
    private String tipo;

    public OrgaoPublico(String tipo, String nome) {
        super(nome);
        this.tipo = tipo;
    }
    
     @Override
    public float calcularConta(Consumo consumo) {
        return 100;
    }
    

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

   
    
    
    
    
    
}
