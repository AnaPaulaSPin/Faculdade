package com.mycompany.ligacaotelefonica;

public class Ligacao {

    public static void main(String[] args) {
        Tempo inicio = new Tempo(13,40,30);
        Tempo fim = new Tempo(14,50,10);
        
        LigacaoTelefonica l1 = new LigacaoTelefonica(inicio,7198231,"bahia", 7190224, "Sao Paulo");
        
        l1.TerminarLigacao(fim);
        l1.calcularValor();
        
    }
}
