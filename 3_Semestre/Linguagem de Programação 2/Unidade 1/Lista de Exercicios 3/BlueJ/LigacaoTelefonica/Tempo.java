 public class Tempo {
    private int hora;
    private int minuto;
    private int segundos;
    
    public Tempo(int hora, int minutos, int segundos){
        this.hora = hora;
        this.minuto = minutos;
        this.segundos = segundos;
    }
    
    public int conversao(){
        int minutos;
        minutos = this.getHora() * 60;
        minutos = minutos + this.getMinuto();
        
        System.out.println("Minutos da ligacao: " + minutos);
        
        return minutos;
    }


    public int getHora() {
        return hora;
    }
    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }
    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }


    public int getSegundos() {
        return segundos;
    }
    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }
    
    
}
