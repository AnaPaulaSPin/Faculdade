
package com.mycompany.sbc;

import java.util.ArrayList;

public class Evento {
    private String nome, periodo, datalimite;
    private ArrayList<Artigos> artigos;

    public Evento(String nome, String periodo, String datalimite) {
        this.nome = nome;
        this.periodo = periodo;
        this.datalimite = datalimite;
        this.artigos = new ArrayList<>();
    }
    
    public float valorArrecadado(){
        float total = 0;
        for(Artigos artg: artigos){
            total+= artg.taxaSubmicao();
        }
        return total;
    }
    
    public int artigosPesquisador(String nome){
        int cont = 0;
        for(Artigos artg: artigos){
            if(artg.encontrarPesquisador(nome)){
                cont++;
            }
        }
        return cont;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getDatalimite() {
        return datalimite;
    }

    public void setDatalimite(String datalimite) {
        this.datalimite = datalimite;
    }

    public ArrayList<Artigos> getArtigos() {
        return artigos;
    }

    public void addArtigos(Artigos artigo) {
        this.artigos.add(artigo);
    }
    
    
    
    
}
