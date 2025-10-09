 public class Carteira
{
   private int numero;
   double cpf;
   String tipo;
   int datValidade;
   int datExpedicao;
   private int pontos;
   String situacao;
   
   // funcao de encapsulamento set e get:
   public void setNumero(int numero){
       this.numero = numero;
       
   }
   
   public int getNumero(int numero){
       return this.numero;
       
   } // -> Fazer isso com todas as variaveis
   
   public void setPontos(int pontos){
       this.pontos = pontos;
       
   }
   
   public int getPontos(){
       return this.pontos;
   }
   
   // Construtor:
   public Carteira (int numero, float cpf,String tipo,int datValidade, int datExpedicao){
       this.numero = numero;
       this.cpf = cpf;
       this.tipo = tipo;
       this.datExpedicao = datExpedicao;
       this.datValidade = datValidade;
       this.pontos = 0;
       this.situacao = "valida";
       
   }
   
   void acrescentarPontos(int pontos){
       System.out.println("Infracao registrada, 5 pontos foram adicionados a sua carteira.");
       
       this.setPontos(pontos);
    }
    
   void consultarPontos(){
       System.out.println("Voce possui: " + this.pontos + " pontos ao total");
   }
   
   void zerarCarteira(){
       this.pontos = 0;
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
