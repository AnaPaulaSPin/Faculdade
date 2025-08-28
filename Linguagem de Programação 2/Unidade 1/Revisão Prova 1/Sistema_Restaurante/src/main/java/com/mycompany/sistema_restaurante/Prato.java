
package com.mycompany.sistema_restaurante;

public class Prato {
    private String nome;
    private String tipo;
    private float valor;
    private int tempoPreparo;
    
    public Prato(String nome, String tipo, float valor, int tempoPreparo){
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
        this.tempoPreparo = tempoPreparo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(int tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }
    
    
}
