package com.mycompany.seguradora;

public class Residencial extends Seguro implements Print{
    private String endereco;
    private int anoConst;

    public Residencial(String endereco, int anoConst, String benificiario) {
        super(benificiario);
        this.endereco = endereco;
        this.anoConst = anoConst;
    }
    
    @Override
    public float calcularValor(){
        
        return 100;
        
    }
    
    @Override
    public void imprimir() {
       System.out.println("Nome: " + this.getBeneficiario());
       System.out.println("Valor da Apolice: " + this.getValorApolice());
       System.out.println("Endereco da Casa: " + this.getEndereco());
       System.out.println("Ano de Construcao da Casa: " + this.getAnoConst());
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getAnoConst() {
        return anoConst;
    }

    public void setAnoConst(int anoConst) {
        this.anoConst = anoConst;
    }
    
    
}
