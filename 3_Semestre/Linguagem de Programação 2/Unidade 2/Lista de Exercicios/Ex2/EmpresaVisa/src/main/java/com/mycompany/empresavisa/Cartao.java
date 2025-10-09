
package com.mycompany.empresavisa;

import java.util.ArrayList;

public abstract class Cartao implements Print {
    private int codPrincipal;
    private int CVV;
    private int dataExpedicao;
    private int validade;
    private int limite;
    private ArrayList<Compra> compras;

    public Cartao(int codPrincipal, int CVV, int dataExpedicao, int validade, int limite) {
        this.codPrincipal = codPrincipal;
        this.CVV = CVV;
        this.dataExpedicao = dataExpedicao;
        this.validade = validade;
        this.limite = limite;
        this.compras = new ArrayList<>();
    }
    
    public abstract float calcularPontos();
    
    public float calcularTotal(){
        float total = 0;
        for(Compra cont: compras){
            total += cont.getValor();
        }
        
        return total;
    }
    
    
    @Override
    public void imprimir(){
        
    }

    public int getCodPrincipal() {
        return codPrincipal;
    }

    public void setCodPrincipal(int codPrincipal) {
        this.codPrincipal = codPrincipal;
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }

    public int getDataExpedicao() {
        return dataExpedicao;
    }

    public void setDataExpedicao(int dataExpedicao) {
        this.dataExpedicao = dataExpedicao;
    }

    public int getValidade() {
        return validade;
    }

    public void setValidade(int validade) {
        this.validade = validade;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public ArrayList<Compra> getCompras() {
        return compras;
    }

    public void addCompras(Compra compras) {
        this.compras.add(compras);
    }
    
    

}
