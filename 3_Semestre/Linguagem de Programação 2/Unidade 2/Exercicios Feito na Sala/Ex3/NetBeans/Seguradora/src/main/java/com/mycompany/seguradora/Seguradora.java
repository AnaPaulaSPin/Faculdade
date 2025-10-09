package com.mycompany.seguradora;

public class Seguradora {

    public static void main(String[] args) {
        Vida s1 = new Vida("Ana",19);
        Automovel s2 = new Automovel(123, 2013, "Sarah");
        Residencial s3 = new Residencial("Rua do Limoeiro", 2005, "Elisabeth");
        
        s1.setValorApolice( s1.calcularValor());
        s2.setValorApolice( s2.calcularValor());
        s3.setValorApolice( s3.calcularValor());
        
        Empresa empr1 = new Empresa("Mais Seguro");
        
        empr1.addSeguros(s1);
        empr1.addSeguros(s2);
        empr1.addSeguros(s3);
        
        empr1.imprimirListas();
        
        
    }
}
