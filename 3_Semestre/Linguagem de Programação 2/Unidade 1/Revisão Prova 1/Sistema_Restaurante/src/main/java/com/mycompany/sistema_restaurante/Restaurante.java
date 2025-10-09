
package com.mycompany.sistema_restaurante;

import java.util.ArrayList;

public class Restaurante {
    private String nome;
    private ArrayList<Cliente> clientes;
    private ArrayList<Pedido> pedidos;
    private ArrayList<Prato> cardapio;

    public Restaurante(String nome){
        this.nome= nome;
        this.clientes= new ArrayList<>();
        this.pedidos = new ArrayList<>();
        this.cardapio= new ArrayList<>();
    }
    
    public boolean encontrarCliente(int cpf){
        for(Cliente cliente: clientes){
            if(cliente.getCpf()== cpf){
                return true;
            }
        }
        return false;
    }
    
    public Cliente clienteMaisCompra(){
        float maior = 0; Cliente vip = null;
        for (Cliente cliente:clientes){
            if(maior < cliente.gastoTotal()){
                maior = cliente.gastoTotal();
                vip = cliente;
            }
        }
        return vip;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public ArrayList<Cliente> getClientes(){
        return this.clientes;
    }
    public void addClientes(Cliente cliente){
        this.clientes.add(cliente);
    }
    
    public ArrayList<Pedido> getPedidos(){
        return this.pedidos;
    }
    public void addPedido(Pedido pedido){
        this.pedidos.add(pedido);
    }
    
    public ArrayList<Prato> getCardapio(){
        return this.cardapio;
    }
    public void addCardapio(Prato prato){
        this.cardapio.add(prato);
    }
    
    
}
