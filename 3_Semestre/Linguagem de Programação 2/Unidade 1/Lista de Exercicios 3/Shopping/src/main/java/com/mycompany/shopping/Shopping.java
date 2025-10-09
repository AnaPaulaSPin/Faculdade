package com.mycompany.shopping;

public class Shopping {

    public static void main(String[] args) {
        Loja l1 = new Loja("C&A","Vender Roupa", 1313,2113,200);
        Loja l2 = new Loja("Riachuelo","Vender Roupa", 1314,2115,300);
        
        l2.setFat(1000);
        l1.setFat(2000);
        
        l1.calcularAluguel();
        l2.calcularAluguel();
        
        ShoppingCenter salvador = new ShoppingCenter("Shopping Salvador");
        
        salvador.addLoja(l1);
        salvador.addLoja(l2);
        
        salvador.verificarMediaAlugueis();
        
        salvador.maiorFat();
    }
}
