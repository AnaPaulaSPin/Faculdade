package com.mycompany.sistema_biblioteca_digital;

public class Sistema_Biblioteca_Digital {

    public static void main(String[] args) {
        Livraria leitura = new Livraria("Leitura");
        Livros livro1 = new Livros("Melhor do que nos filmes", "Lynn", 200, "Romance juvenil");
        Livros livro2 = new Livros("Anjo mecanico", "Cassandra", 500, "Romance juvenil", "avancado");
        Livros livro3 = new Livros("Principe Mecanico", "Cassandra", 500, "Romance juvenil", "avancado");
        Livros livro4 = new Livros("Princesa Mecanica", "Cassandra", 500, "Romance juvenil", "avancado");
        
        leitura.addLivros(livro1);
        leitura.addLivros(livro2);
        leitura.addLivros(livro3);
        leitura.addLivros(livro4);
        
        Leitores leitor1 = new Leitores("Aninha", "paulinhasp148@gmail.com", 2005, "anual");
        Leitores leitor2 = new Leitores("Lay", "laurinha@gmail.com", 2007, "mensal");
        
        boolean teste = leitor2.verificarLivro(livro4);
        
        //adicionando um livro:
        leitor1.addLivros(livro1);
        livro1.addLeitores(leitor1);
        
        leitor2.addLivros(livro1);
        livro1.addLeitores(leitor2);
        
      
        System.out.println(teste);
        
        teste = leitor1.verificarLivro(livro4);
        
        System.out.println(teste);
        
        leitura.LivroMaisLido();
        
    }
}
