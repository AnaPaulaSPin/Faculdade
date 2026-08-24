public class CD extends MemoriaS{
     public static final int ABERTO = 0;
     public static final int FECHADO = 1;
     private int estado;

     public CD(int newTotal,int newUnidade){
        this.estado = ABERTO;
        super(newTotal, newUnidade);
     }

     @Override
     public double getEspacoDisponivelRealKB(){
        return this.getEspacoDisponivelKB()*0.98;
     }

     @Override
     public boolean GravaKB(int newTamanho){
        if(this.estado == ABERTO){
           if(this.getUtilizadoKB() + newTamanho > this.getTotal()){
             return false;
        } else{
         this.setUtilizadoKB(this.getUtilizadoKB() + newTamanho);
         return true;
       }
     } else{
        return false;
     }
    }
    
     @Override
     public double getPerda(){
        return this.getConverteKB(this.getTotal()) * 0.98;
     }

     public String getEstado(){
        if(this.estado == ABERTO){
            return "Aberto";
        } else{
            return "Fechado";
        }

     }

     public String toString(){
        return "CD Estado " + this.getEstado() + " Percentual Disponível " + this.getPercentualDisponivel() + "% Espaço Total " + this.getTotal() + " KB Espaço Disponível Real " + this.getEspacoDisponivelRealKB() + "KB Perda " + this.getPerda() + "%";
     }

 
}
