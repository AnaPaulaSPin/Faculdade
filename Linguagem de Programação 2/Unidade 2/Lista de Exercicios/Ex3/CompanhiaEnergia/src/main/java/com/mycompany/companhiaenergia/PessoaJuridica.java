
package com.mycompany.companhiaenergia;

public class PessoaJuridica extends Cliente {
    private String cnpj; 

    public PessoaJuridica(String cnpj, String nome) {
        super(nome);
        this.cnpj = cnpj;
    }
    
    @Override
    public float calcularConta(Consumo consumo) {
        if(consumo.getKw()<= 80){
            return 60;
        } else{
            int kw = consumo.getKw() - 80;
            return kw * 1 + 60;
        }
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
}
