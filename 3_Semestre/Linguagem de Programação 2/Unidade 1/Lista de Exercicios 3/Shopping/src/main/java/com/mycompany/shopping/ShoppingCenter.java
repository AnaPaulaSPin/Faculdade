
package com.mycompany.shopping;

import java.util.ArrayList;

public class ShoppingCenter {
    private String name;
    private ArrayList<Loja> lojas;
    
    public ShoppingCenter(String nome){
        this.name = nome;
        this.lojas = new ArrayList<>();
    }
    
    
    public void maiorFat(){
        float maior = 0;
        String nomFantasia = null;
        
        for (Loja loja : lojas) {
        if (maior < loja.getFat()) {
            maior = loja.getFat();
            nomFantasia = loja.getnome(); // aqui você precisa pegar o nome da loja
        }
    }
        System.out.println("Loja com maior faturamento: " + nomFantasia + " (Faturamento: " + maior + ")");
        
    }

    public void verificarMediaAlugueis(){
        float fat = 0; int qtdLojas = 0;
        
        for(Loja loja : lojas){
            if(loja.getAluguel() >= 1000){
                fat += loja.getAluguel();
                qtdLojas++;
            }
        }
        if (qtdLojas > 0) {
        fat /= qtdLojas;
        System.out.println("A media de alugueis acima de 1000 e: " + fat);
        
        } else {
        System.out.println("Nao ha lojas com aluguel acima de 1000.");
        }
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void addLoja(Loja loj){
        this.lojas.add(loj);
    }
    
    public ArrayList<Loja> getShop(){
        return this.lojas;
    }
    
    
}
