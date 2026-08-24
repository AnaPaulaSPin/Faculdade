public class Ponto {
  private int x;
  private int y;
  
  public Ponto(int x, int y){
      this.x = x;
      this.y = y;
  }
  
  public Ponto(){
    this(0,0);  
  }
  
  public Ponto(int x){
     this(x,0);
  }
  
  void setX(int x){
      this.x = x;
  }
  
  int getX(){
      return this.x;
  }
  
  void setY(int x){
      this.y = y;
  }
  
  int getY(){
      return this.y;
  }
  
  public String toString(){
      return "X= " + this.getX() + "Y= " + this.getY();
  }
  
  public static void main(String args[]) {
        
    }
}