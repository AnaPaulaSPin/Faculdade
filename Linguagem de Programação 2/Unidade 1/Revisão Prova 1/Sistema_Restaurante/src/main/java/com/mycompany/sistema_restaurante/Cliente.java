
package com.mycompany.sistema_restaurante;

import java.util.ArrayList;

public class Cliente {
    private String nome;
    private int cpf;
    private ArrayList<Pedido> pedidos;
    
    public Cliente(String nome, int cpf){
        this.nome = nome;
        this.cpf = cpf;
        this.pedidos = new ArrayList<>();
    }
    
    public int PedidosTipos(String tipo){
        int qtd = 0;
        for(Pedido ped: pedidos){
            for(Prato prat: ped.getPratos()){
                if(prat.getTipo().equals(tipo)){
                    qtd++;
                }
            }
        }
        return qtd;
    }
    
    public String MaiorPedidoTipo(){
        String[] tipos = {"entrada", "sobremesa", "acompanhamento", "principal"};
        int maior = 0; String nome = null;
        
        for(String tipo: tipos){
            if(maior < this.PedidosTipos(tipo)){
                maior = this.PedidosTipos(tipo);
                nome = tipo;
            }
        }
        return nome;
    }
    
    public float gastoTotal(){
        float total = 0 ;
        for(Pedido pedido: pedidos){
            total += pedido.calcularValorTotal();
        }
        return total;
    }
    
     public ArrayList<Pedido> getPedidos(){
        return this.pedidos;
    }
    public void addPedido(Pedido pedido){
        this.pedidos.add(pedido);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
}
