package com.mycompany.faculdade;

public class Faculdade {

    public static void main(String[] args) {
        Facul f1 = new Facul("UNEB", 1888);
        Curso c1 = new Curso(1,"Sistema de Informação",9,3000, 2005);
        
        f1.AdicionarCurso(c1);
        
        Curso c2 = new Curso(2,"Sistema de Informação",0,2000, 2003);
        
        f1.AdicionarCurso(c2);
        
      
        
    }
}
