
package com.mycompany.shopping;

public class Loja {
    private String nome;
   private String razaoSocial;
   private int numCnpj;
   private int digCnpj;
   private float fat;
   private float area;
   private float aluguel;
   private String publicoAlvo;
   
   //Construtor 1:
   public Loja(String nome, String razaoSocial, int numCnpj, int digCnpj, int area){
    this.nome = nome;
    this.razaoSocial = razaoSocial;
    this.numCnpj = numCnpj;
    this.digCnpj = digCnpj;
    this.area = area;
   }

   // Construtor 2:
   public Loja(String nome, String razao, int numCnpj, int digCnpj, float fat, String publicoAlvo, int area){
    this(nome,nome,numCnpj,digCnpj, area);

    this.fat = fat;
    this.publicoAlvo = publicoAlvo;

   }
   
   //Metodo para verificar a fatura da loja: 
   public void verificarFaturamente(Loja fatLoja2){
    if(this.getFat() > fatLoja2.getFat()){
        System.out.print("A loja " + this.getnome() + " possui um faturamento maior que a loja " + fatLoja2.getnome() );

    } else{
        System.out.print("A loja " + fatLoja2.getnome() + " possui um faturamento maior que a loja " + this.getnome() );
    }

   }

   public void calcularAluguel(){
    float area1 = this.getArea();
    area1 *= 50;
    System.out.println("Seu aluguel sera de: " + area1);
    this.setAluguel(area1);
    
    
   }
   
   public void setnome(String nome){
       this.nome = nome;
   }
   
   public String getnome(){
       return this.nome;
    }
    
    public void setRazaoSocial(String razaoSocial){
       this.razaoSocial = razaoSocial;
   }
   
   public String getRazaoSocial(){
       return this.razaoSocial;
    }
    
    public void setNumCnpj(int numCnpj){
       this.numCnpj = numCnpj;
   }
   
   public int getNumCnpj(){
       return this.numCnpj;
    }
    
    public void setDigCnpj(int digCnpj){
       this.digCnpj = digCnpj;
   }
   
   public int getDigCnpj(){
       return this.digCnpj;
    }
    
    public void setFat(float fat){
       this.fat = fat;
   }
   
   public float getFat(){
       return this.fat;
    }
    
    public void setArea(float area){
       this.area = area;
   }
   
   public float getArea(){
       return this.area;
    }
    
    public void setPublicoAlvo(String publicoAlvo){
        this.publicoAlvo = publicoAlvo;        
    }
    
    public String getPublicoAlvo(String publicoAlvo){
        return this.publicoAlvo;
    }


    public float getAluguel() {
        return aluguel;
    }
    public void setAluguel(float aluguel) {
        this.aluguel = aluguel;
    }
    

}
