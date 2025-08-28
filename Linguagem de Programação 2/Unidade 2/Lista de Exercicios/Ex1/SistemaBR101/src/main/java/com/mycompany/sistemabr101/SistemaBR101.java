
package com.mycompany.sistemabr101;


public class SistemaBR101 {

    public static void main(String[] args) {
        Empresa brt = new Empresa("BRT Salvador");
       Pequeno moto = new Pequeno("moto", "BRT67", 2005 );
       Carga caminhao = new Carga(100,"BRT68", 2005 );
       Passeio carro = new Passeio(4,"BRT69", 2005 );
       
       Contrato cliente1 = new Contrato("Sarah", "234618-29", "Alto das margaridas", "sarah@gmail.com", "7190241");
       Contrato cliente2 = new Contrato("Ana", "23145-29", "Alpaphile", "ana@gmail.com", "71921645");
       
       cliente1.addAutomoveis(moto);
       cliente1.addAutomoveis(caminhao);
       cliente2.addAutomoveis(carro);
       
       brt.addClientes(cliente1);
       brt.addClientes(cliente2);
       
       Data dt1 = new Data(20,11,2019);
       Data dt2 = new Data(19,11,2019);
       Data dt3 = new Data(18,11,2019);
       Data dt4 = new Data(16,11,2019);
       Data dt5 = new Data(17,11,2019);
       
       Passagem pass1 = new Passagem(dt1,"12h");
       Passagem pass2 = new Passagem(dt2,"12h");
       Passagem pass3 = new Passagem(dt3,"12h");
       Passagem pass4 = new Passagem(dt4,"12h");
       Passagem pass5 = new Passagem(dt5,"12h");
       
       moto.addPassagens(pass1);
       moto.addPassagens(pass2);
       moto.addPassagens(pass3);
       
       carro.addPassagens(pass5);
       carro.addPassagens(pass4);
       
       System.out.println("No mes de novembro vc pagara a seguinte fatura: "  + cliente1.CalcularFatura(11));
       System.out.println("No mes de novembro o cliente que mais gastou foi: "+ brt.ClienteVipMes(11).getNome() + " onde gastou:  " + cliente2.CalcularFatura(11)+ "$");
    }
}
