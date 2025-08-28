
package com.mycompany.sbc;

import java.util.ArrayList;

public class Artigos {
    protected String titulo, resumo, textoCompleto;
    protected int pag;
    protected ArrayList<Pesquisador> autores;

    public Artigos(String titulo, String resumo, String textoCompleto, int pag) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.textoCompleto = textoCompleto;
        this.pag = pag;
        this.autores = new ArrayList<>();
    }
    
    public float taxaSubmicao(){
        return this.getPag() * 10;
    }
    
    public boolean encontrarPesquisador(String nome){
        for(Pesquisador aut: autores){
            if(aut.getNome().equals(nome)){
                return true;
            }
        }
        return false;
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

    public void addAutores(Pesquisador autor) {
        this.autores.add(autor);
    }
    
    
}
