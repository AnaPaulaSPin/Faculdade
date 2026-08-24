public class Main{
  public static void main(String args[]) {  
    Ponto p = new Ponto();
    System.out.print("Ponto x = " + p.getX() + " y= " + p.getY() + "\n");
    System.out.println(p);
    Ponto p3d = new Ponto3D(1,2,3);
    
    System.out.print("Ponto x = " + p3d.getX() + " y= " + p3d.getY());
    
    Ponto3D p1 = (Ponto3D)p3d;
    System.out.println("Ponto z= " + p1.getZ());
      
  }
    
}