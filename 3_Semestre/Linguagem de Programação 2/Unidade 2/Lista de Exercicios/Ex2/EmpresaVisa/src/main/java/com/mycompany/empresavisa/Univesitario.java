
package com.mycompany.empresavisa;

public class Univesitario extends Cartao {
    private String instituicao;

    public Univesitario(String instituicao, int codPrincipal, int CVV, int dataExpedicao, int validade) {
        super(codPrincipal, CVV, dataExpedicao, validade,300);
        this.instituicao = instituicao;
    }
    
    @Override
    public void imprimir() {
       
    }
    
    @Override
    public float calcularPontos(){
        return 1;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    } 

    
}
