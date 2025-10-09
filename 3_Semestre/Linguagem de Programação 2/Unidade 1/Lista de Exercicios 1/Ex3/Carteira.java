 


public class Carteira
{
   int identNum;
   double cpf;
   String tipo;
   int datValidade;
   int datExpedicao;
   int pontos;
   String situacao;
   
   public Carteira (int identNum, float cpf,String tipo,int datValidade, int datExpedicao){
       this.identNum = identNum;
       this.cpf = cpf;
       this.tipo = tipo;
       this.datExpedicao = datExpedicao;
       this.datValidade = datValidade;
       this.pontos = 0;
       this.situacao = "valida";
       
       
   }
   
   void acrescentarPontos(){
       System.out.println("Infracao registrada, 5 pontos foram adicionados a sua carteira.");
       this.pontos += 5;
    }
    
   void consultarPontos(){
       System.out.println("Voce possui: " + this.pontos + " pontos ao total");
   }
   
   void zerarCarteira(){
       this.pontos = 0;
       this.situacao = "valida";
   }
   
   void apreenderCarteira(){
       if(this.pontos > 20){
           System.out.println("Carteira Apreendida");
           this.situacao = "apreendida";
           
       } else{
           this.situacao = "valida";
       }
       
   }
   
   void verificatValidade(){
       
   }
}
