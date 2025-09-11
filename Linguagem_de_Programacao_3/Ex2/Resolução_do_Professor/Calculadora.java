public class Calculadora {
    private double num1;
    private double  num2;
    private char op;

    
   public void setNum1(double num){
         this.num1 = num;
   }

   public double getNum1(){
    return this.num1;
   }

   public void setNum2(double num){
         this.num2 = num;
   }

   public double getNum2(){
    return this.num2;
   }

   public void setSinal(char sinal){
         this.op = sinal;
   }

   public char getSinal(){
    return this.op;
   }
    
}