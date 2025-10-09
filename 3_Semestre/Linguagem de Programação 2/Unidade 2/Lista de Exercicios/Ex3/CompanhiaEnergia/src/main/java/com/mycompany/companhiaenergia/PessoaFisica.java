
package com.mycompany.companhiaenergia;

public class PessoaFisica extends Cliente{
    private String cpf;

    public PessoaFisica(String cpf, String nome) {
        super(nome);
        this.cpf = cpf;
    }
    
    @Override
    public float calcularConta(Consumo consumo) {
        if(consumo.getKw()<= 100){
            return 40;
        } else{
            int kw = consumo.getKw() - 100;
            return kw * 0.80f + 40;
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
    
}
