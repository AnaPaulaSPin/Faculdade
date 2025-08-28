
package com.mycompany.empresavisa;

public class Cliente {
    private String nome;
    private String cpf;
    private String telefone;
    private Cartao meuCartao;

    public Cliente(String nome, String cpf, String telefone, Cartao meuCartao) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.meuCartao = meuCartao;
    }
    
     public Cliente(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }
     
     public float totalPontos(){
         float pontos = 0;
         for(Compra shop: this.getMeuCartao().getCompras()){
             pontos+= shop.pontosAdquiridos();
         }
         return pontos;
     }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Cartao getMeuCartao() {
        return meuCartao;
    }

    public void setMeuCartao(Cartao meuCartao) {
        this.meuCartao = meuCartao;
    }
    
    
}
