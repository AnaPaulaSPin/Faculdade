
package com.mycompany.seguradora;

public abstract class Seguro implements Print {
    private String beneficiario;
    private float valorApolice;
    
    public Seguro(String benificiario){
        this.beneficiario = benificiario;
        
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }

    public float getValorApolice() {
        return valorApolice;
    }

    public void setValorApolice(float valorApolice) {
        this.valorApolice = valorApolice;
    }
    
    public abstract float calcularValor();
    
    
}
