package com.mycompany.sistema_biblioteca_digital;

import java.util.ArrayList;

public class Livraria {
    private String nome;
    private ArrayList<Leitores> leitores;
    private ArrayList<Livros> livros;
    
    public Livraria(String nome){
        this.nome = nome;
        this.livros = new ArrayList<>();
        this.leitores = new ArrayList<>();
    }
    
    public float percentualLidos(Livros book){
        int qtd = 0;
        for(Leitores leitor:leitores){
            for(Livros livro:leitor.getLivros()){
                if(livro.getTitulo().equals(book.getTitulo())){
                    qtd++;
                    break;
                }
            }
        }
        return (qtd / this.leitores.size()) * 100; 
    }
    
    public String LivroMaisLido(){
        int maior = 0 ; String nome = null;
        
        for(Livros book: livros){
            if(maior < book.getLeitores().size()){
                maior = book.getLeitores().size();
                nome = book.getTitulo();
            }
        }
        return nome;
    }
    
    
    public ArrayList<Livros> getLivros(){
        return this.livros;
    }
    
    public void addLivros(Livros livro){
        this.livros.add(livro);
    }
    
    public ArrayList<Leitores> getLeitores(){
        return this.leitores;
    }
    public void addLeitores(Leitores leitor){
        this.leitores.add(leitor);
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    
}
