
package com.mycompany.empresavisa;


public class Compra implements Print {
    private String estabelicimento;
    private String endereco;
    private int data;
    private Cartao cartao;
    private float valor;
    private float pontos;

    public Compra(String estabelicimento, String endereco, int data, Cartao cartao, float valor) {
        this.estabelicimento = estabelicimento;
        this.endereco = endereco;
        this.data = data;
        this.cartao = cartao;
        this.valor = valor;
    }
    
    @Override
    public void imprimir(){
        System.out.println(" Sua compra foi efeituada com sucesso!");
        System.out.println("Estabelecimento: " + this.getEstabelicimento());
        System.out.println("Endereco: " + this.getEndereco());
        System.out.println("Data: " + this.getData());
        System.out.println("Cartao: ");
        this.getCartao().imprimir();
        System.out.println("Valor da compra: " + this.getValor());
    }
    
    public void gerarPontos(){
        this.setPontos(cartao.calcularPontos() * this.getValor());
    }
    
    public float pontosAdquiridos(){
        return this.getValor() * cartao.calcularPontos();
    }

    public String getEstabelicimento() {
        return estabelicimento;
    }

    public void setEstabelicimento(String estabelicimento) {
        this.estabelicimento = estabelicimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public float getValor() {
        return this.valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getPontos() {
        return pontos;
    }

    public void setPontos(float pontos) {
        this.pontos = pontos;
    }
    
    
}
