

package com.mycompany.faculdade;

public class Curso
{
    private int cod;
    private String nome;
    private int duracao;
    private float valorCurso;
    private int anoCriacao;
    
    public Curso(int cod, String nome, int duracao, float valorCurso, int anoCriacao){
    this.cod = cod;
    this.nome = nome;
    this.duracao = duracao;
    this.valorCurso = valorCurso;
    this.anoCriacao = anoCriacao;
   }
    
   // sem escrever a duração
   public Curso(int cod, String nome, float valorCurso, int anoCriacao){
    this(cod, nome, 0, valorCurso, anoCriacao);
    if(this.getDuracao() == 0 ){
        this.setDuracao(8);
    }
   }

   public void calcularMensalidade(){
    double valor = this.getValorCurso();
    
    System.out.println("O valor da sua mensalidade e de: " + valor);

    valor /= this.getDuracao();

    System.out.println("Voce paragara em seus "+ this.getDuracao() + " semestres, o valor de " + valor);

   }
    
    //sets e gets
    public void setCod(int cod){
        this.cod = cod;
    }
    
    public int getCod(){
        return this.cod;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setDuracao(int duracao){
        this.duracao = duracao;
    }
    
    public int getDuracao(){
        return this.duracao;
    }
    
    public void setValorCurso(float valorCurso){
        this.valorCurso = valorCurso;
    }
    
    public float getValorCurso(){
        return this.valorCurso;
    }
    
    public void setAnoCriacao(int anoCriacao){
        this.anoCriacao = anoCriacao;
    }
    
    public int getAnoCriacao(){
        return this.anoCriacao;
    }   
}

