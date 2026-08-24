public class HD extends MemoriaS {
    private String numeroSerie;

    public HD(String newNumeroSerie,int newTotal,int newUnidade){
        this.numeroSerie = newNumeroSerie;
        super(newTotal,newUnidade);
    }
    
    @Override
    public double getEspacoDisponivelRealKB(){
        return this.getEspacoDisponivelKB()*(1-this.getPerda());

    }

    @Override
    public double getPerda(){
        return this.getConverteKB(this.getTotal()) / 10240 / 100;
    }

    public String getNumeroSerie(){
        return this.numeroSerie;
    }

    public String toString(){
        return "HD Número de Serie " + this.getNumeroSerie() + " Percentual Disponível " + this.getPercentualDisponivel() + "% Espaço Total " + this.getTotal() + " KB Espaço Disponível Real " + this.getEspacoDisponivelRealKB() + "KB Perda " + this.getPerda() + "%";
    }


}
