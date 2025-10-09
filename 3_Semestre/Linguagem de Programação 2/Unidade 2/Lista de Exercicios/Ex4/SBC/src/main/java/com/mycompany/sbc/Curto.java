
package com.mycompany.sbc;

import java.util.ArrayList;

public class Curto extends Artigos {
    private String instituicao;

    public Curto(String instituicao, String titulo, String resumo, String textoCompleto, int pag) {
        super(titulo, resumo, textoCompleto, pag);
        this.instituicao = instituicao;
        this
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getTextoCompleto() {
        return textoCompleto;
    }

    public void setTextoCompleto(String textoCompleto) {
        this.textoCompleto = textoCompleto;
    }

    public int getPag() {
        return pag;
    }

    public void setPag(int pag) {
        this.pag = pag;
    }

    public ArrayList<Pesquisador> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<Pesquisador> autores) {
        this.autores = autores;
    }

    
    
    
    
}
