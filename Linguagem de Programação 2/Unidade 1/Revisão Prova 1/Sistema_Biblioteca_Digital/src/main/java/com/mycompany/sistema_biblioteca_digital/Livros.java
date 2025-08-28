package com.mycompany.sistema_biblioteca_digital;

import java.util.ArrayList;


public class Livros {
    private String titulo;
    private String autor;
    private int paginas;
    private String categoria;
    private String nivel;
    private ArrayList<Leitores> leitores;
    
    public Livros(String titulo, String autor, int paginas, String categoria, String nivel){
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        this.categoria = categoria;
        this.nivel = nivel;
        this.leitores = new ArrayList<>();
    }
    
    public Livros(String titulo, String autor, int paginas, String categoria){
        this(titulo, autor, paginas, categoria, "intermediario");
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPaginas() {
        return paginas;
    }
    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNivel() {
        return nivel;
    }
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    
    public ArrayList<Leitores> getLeitores(){
        return this.leitores;
    }
    public void addLeitores(Leitores leitor){
        this.leitores.add(leitor);
    }
    
    
}
