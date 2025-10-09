package com.mycompany.sistema_restaurante;


public class Sistema_Restaurante {

    public static void main(String[] args) {
        Restaurante Mac = new Restaurante("Mc Donnalds");
        
        Prato batata = new Prato("batata frita", "acompanhamento", 5, 5);
        Prato hambuguerExtra = new Prato("Chikked", "principal", 10, 9);
        Prato hambuguer = new Prato("Feliz da vida", "principal", 20, 9);
        Prato sorvete = new Prato("Misto com chocale", "sobremesa", 8, 2);
        
        Mac.addCardapio(batata);
        Mac.addCardapio(hambuguerExtra);
        Mac.addCardapio(hambuguer);
        Mac.addCardapio(sorvete);
        
        Cliente cliente1 = new Cliente("Ana", 866);
        Cliente cliente2 = new Cliente("Sarah", 766);
        Cliente cliente3 = new Cliente("Beatriz", 866);
        
        Mac.addClientes(cliente1);
        Mac.addClientes(cliente2);
        Mac.addClientes(cliente3);
        
        Pedido pedido1 = new Pedido(1,cliente1,10);
        cliente1.addPedido(pedido1);
        pedido1.addPratos(batata);
        pedido1.addPratos(hambuguer);
       
        
        Pedido pedido2 = new Pedido(2,cliente1,10);
        cliente1.addPedido(pedido2);
        pedido1.addPratos(batata);
        pedido1.addPratos(hambuguer);
        pedido1.addPratos(batata);
        
        boolean teste;
        String  testes1;
        
        testes1 = cliente1.MaiorPedidoTipo();
        
        System.out.println(testes1);
        
       Cliente vip = Mac.clienteMaisCompra();
       
       System.out.println(vip.getNome());
       
      teste = Mac.encontrarCliente(76);
      
      System.out.println(teste);
        
        
        
        
        
        
    }
}
