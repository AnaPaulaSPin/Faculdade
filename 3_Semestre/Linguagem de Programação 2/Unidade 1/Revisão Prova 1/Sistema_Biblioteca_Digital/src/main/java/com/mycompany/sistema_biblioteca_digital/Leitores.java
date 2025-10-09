package com.mycompany.sistema_biblioteca_digital;

import java.util.ArrayList;


public class Leitores {
    private String nome;
    private String email;
    private int dataRegist;
    private String plano;
    private ArrayList<Livros> livros;
    
    public Leitores(String nome, String email, int data, String plano){
        this.nome = nome;
        this.email = email;
        this.dataRegist = data;
        this.plano = plano;
        this.livros = new ArrayList<>();
    }
    
    public boolean verificarLivro(Livros book){
        if(book.getNivel().equals("avancado") && !this.getPlano().equals("anual")){
            return false;
        }
        return true;
    }
    
    public int livrosCat(String categoria){
        int qtd = 0;
        for(Livros book: livros){
            if(book.getCategoria().equals(categoria)){
                qtd++;
            }
        }
        return qtd++;
    }
    
    
    public ArrayList<Livros> getLivros(){
        return this.livros;
    }
    
    public void addLivros(Livros livro){
        this.livros.add(livro);
    }

 
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public int getDataRegistri() {
        return dataRegist;
    }
    public void setDataRegistri(int dataRegistri) {
        this.dataRegist = dataRegistri;
    }

    public String getPlano() {
        return plano;
    }
    public void setPlano(String plano) {
        this.plano = plano;
    }
   
}
