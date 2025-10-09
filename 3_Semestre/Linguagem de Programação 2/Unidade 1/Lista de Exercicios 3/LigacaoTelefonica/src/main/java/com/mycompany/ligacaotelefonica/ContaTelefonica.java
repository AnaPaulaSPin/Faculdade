package com.mycompany.ligacaotelefonica;

public class ContaTelefonica {
    private int mes;
    private int anoReferencia;
    private LigacaoTelefonica[] listaTelefonica;
    private int qtdLigacao;
    private int protocolo;
    
    public ContaTelefonica(int mes, int ano,int protocolo){
        this.mes = mes;
        this.anoReferencia = ano;
        this.protocolo = protocolo;
        this.qtdLigacao = 0;
        this.listaTelefonica = new LigacaoTelefonica[10];
    }
    
    public void adicionarLigacao(LigacaoTelefonica ligacao){
        this.listaTelefonica[qtdLigacao] = ligacao;
        this.setQtdLigacao(this.getQtdLigacao()+1);
        
    }
    
    public float CalcularTotal(){
        float valor = 0; int qtd = this.getQtdLigacao();
        for(int i = 0; i < qtd; i++){
            valor += this.listaTelefonica[i].getValorTotal();
        }
        return valor;
    }
    
    public float CalcularTotal(String local){
        float valor = 0; int qtd = this.getQtdLigacao();
        for(int i = 0; i < qtd; i++){
            if(this.listaTelefonica[i].getLocalDestino().equals(local)){
                valor += this.listaTelefonica[i].getValorTotal();
            }
        }
        return valor;
    }



    public int getMes() {
        return mes;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }

    
    public int getAnoReferencia() {
        return anoReferencia;
    }
    public void setAnoReferencia(int anoReferencia) {
        this.anoReferencia = anoReferencia;
    }


    public LigacaoTelefonica[] getListaTelefonica() {
        return listaTelefonica;
    }
    public void setListaTelefonica(LigacaoTelefonica[] listaTelefonica) {
        this.listaTelefonica = listaTelefonica;
    }

    
    public int getQtdLigacao() {
        return qtdLigacao;
    }
    public void setQtdLigacao(int qtdLigadao) {
        this.qtdLigacao = qtdLigadao;
    }

    
    public int getProtocolo() {
        return protocolo;
    }
    public void setProtocolo(int protocolo) {
        this.protocolo = protocolo;
    }
    
    
}
