
package com.mycompany.empresavisa;

public class Basico extends Cartao {

    public Basico(int codPrincipal, int CVV, int dataExpedicao, int validade, int limite) {
        super(codPrincipal, CVV, dataExpedicao, validade, limite);
    }
    @Override
    public void imprimir() {
       
    }
    
    @Override
    public float calcularPontos(){
        return 1;
    }
    
}
