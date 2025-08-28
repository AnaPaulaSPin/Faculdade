
package com.mycompany.sbc;

public class Revista extends Longo{
    private String instituicao;

    public Revista(String titulo, String resumo, String textoCompleto, int pag, String instuicao) {
        super(titulo, resumo, textoCompleto, pag);
        this.instituicao = instuicao;
    }
    
    @Override
    public float taxaSubmicao(){
        return (this.getPag() * 10) * 0.15f;
    }
    

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }
    
    
    
    
}
