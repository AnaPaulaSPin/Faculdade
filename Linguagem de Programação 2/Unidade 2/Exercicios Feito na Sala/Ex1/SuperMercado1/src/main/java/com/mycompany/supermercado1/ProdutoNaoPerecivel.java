
package com.mycompany.supermercado1;

public class ProdutoNaoPerecivel extends Produto {
     private String substancia;
     
     public ProdutoNaoPerecivel(int codigo, String nome,  float preco, String substancia){
         super(codigo,nome,preco);
         this.substancia = substancia;
     }
     

    public String getSubstancia() {
        return substancia;
    }

    public void setSubstancia(String substancia) {
        this.substancia = substancia;
    }
     
     
}
