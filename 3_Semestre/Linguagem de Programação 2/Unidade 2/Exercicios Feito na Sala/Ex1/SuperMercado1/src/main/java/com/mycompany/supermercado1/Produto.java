
package com.mycompany.supermercado1;

public class Produto {
    protected int codigo;
    protected String nome;
    protected float preco;
    
    public Produto(int codigo, String nome,  float preco){
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }
    
    public float precoVenda(){
        return this.getPreco();
    }
    
     public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    
}
