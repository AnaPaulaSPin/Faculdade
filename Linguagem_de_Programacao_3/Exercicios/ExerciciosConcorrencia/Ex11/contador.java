public class contador {
   private int contador;

   public contador(){
    this.contador = 0;
   }
   
   public void incrementar(){
     int i = this.getContador() + 1;
     this.setContador(i);
   }

   public int getContador(){
    return this.contador;
   }

   public void setContador(int contador){
    this.contador = contador;

   }
}

