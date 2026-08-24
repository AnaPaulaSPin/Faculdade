public class Ponto3D extends Ponto{
    private int z;
    
    public Ponto3D(int x, int y, int z){
        this.z = z;
        super(y,z);
    }
    
    public static void main(String args[]) {
        
    }
    
    public void setZ(int z){
        this.z = z;
    }
    
    public int getZ (){
        return z;
    }
}
