package com.mycompany.seguradora;

public class Automovel extends Seguro implements Print{
    private int chassi;
    private int anoFabri;

    public Automovel(int chassi, int anoFabri, String benificiario) {
        super(benificiario);
        this.chassi = chassi;
        this.anoFabri = anoFabri;
    }
    
    @Override
    public float calcularValor(){
        
        return 0;
        
    }
    
    @Override
    public void imprimir() {
       System.out.println("Nome: " + this.getBeneficiario());
       System.out.println("Valor da Apolice: " + this.getValorApolice());
       System.out.println("Numero do carro: "+ this.getChassi());
       System.out.println("Ano de fabricacao: " + this.getAnoFabri());
       
    }

    public int getChassi() {
        return chassi;
    }

    public void setChassi(int chassi) {
        this.chassi = chassi;
    }

    public int getAnoFabri() {
        return anoFabri;
    }

    public void setAnoFabri(int anoFabri) {
        this.anoFabri = anoFabri;
    }   
}
