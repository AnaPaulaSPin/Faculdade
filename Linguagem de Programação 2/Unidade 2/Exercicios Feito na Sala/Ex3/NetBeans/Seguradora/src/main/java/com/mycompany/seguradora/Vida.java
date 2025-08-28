
package com.mycompany.seguradora;

public class Vida extends Seguro implements Print{
    private int idade;
    
    public Vida(String benificiario, int idade){
        super(benificiario);
        this.idade = idade;
    }
    
    @Override
    public float calcularValor(){
        
        return 0;
        
    }
    
    @Override
    public void imprimir() {
       System.out.println("Nome: " + this.getBeneficiario());
       System.out.println("Valor da Apolice: " + this.getValorApolice());
       System.out.println("Idade do benificiario: " + this.getIdade());
       
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

 
    
    
}
