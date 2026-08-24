

public abstract class MemoriaS {
    public static final int BYTE = 1;
    public static final int KB = 1024;
    public static final int MB = 1024 * KB;
    public static final int GB = 1024 * MB;

    private double total;
    private double utilizadoKB;
    private int unidade;

    MemoriaS(int newTotal,int newUnidade){
        this.total = newTotal;
        this.unidade = newUnidade;
        this.utilizadoKB = 0;

    }

    MemoriaS(int newTotal) {
        this(newTotal, KB);
    }

    public abstract double getPerda();

    public abstract double getEspacoDisponivelRealKB();

    public double getTotal() {
        return total;
    }

   protected double getEspacoDisponivelKB(){
        return this.getTotal() - this.getUtilizadoKB();
    }

   public boolean GravaKB(int newTamanho) {
    if(utilizadoKB + newTamanho > this.getTotal()){
        return false;
    } else{
        this.utilizadoKB += newTamanho;
        return true;
    }
   }


   protected double getConverteKB(double valor) {
        switch (this.unidade) {
            case BYTE:  
                return valor / KB;
            case KB:
                return valor;
            case MB:
                return valor * KB;
            case GB:
                return valor * MB;
            default:
                throw new IllegalArgumentException("Unidade de memória inválida");
        }
   }

   public String getUnidade(){
    switch (this.unidade) {
            case BYTE:  
                return "BYTE";
            case KB:
                return "KB";
            case MB:
                return "MB";
            case GB:
                return "GB";
            default:
                throw new IllegalArgumentException("Unidade de memória inválida");
        }

   }

  public double getPercentualDisponivel(){
    return this.getEspacoDisponivelRealKB()/ this.getTotal();
  }

  public double getUtilizadoKB(){
    return this.utilizadoKB;
  }

  public void setUtilizadoKB(double utilizadoKB){
    this.utilizadoKB = utilizadoKB;
  }

  public String toString(){
    return "Percentual Disponível: " + this.getPercentualDisponivel() +  "% Espaço Total " + this.total+ "KB Espaço Disponível Real"+ this.getEspacoDisponivelKB() + "KB Perda "+ this.getPerda()+ "%";

  }

}