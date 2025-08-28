
public class Tempo
{
    // variáveis de instância
    private int hora;
    private int minuto;
    private int segundo;

    /**
     * Construtor para objetos da classe Tempo
     */
    public Tempo(int hora, int minuto, int segundo) {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
        
       
    }

    // converter as horas em minutos:
    public int conversao(int hora, int minuto, int segundo)
    {
        int total;
        total = hora * 60 + minuto;
        if(segundo > 0){
            total += 1;
        }
        return total;
    }
    // convercao de inicio da hora da ligação e final dos minutos da ligação para minutos;
    int CalcDif(int inicio, int fim){
        int diferenca;
        diferenca = fim - inicio;
        return diferenca;
    }
    
    public int getHora(){
        return this.hora;
    }
    
    public void setHora( int hora){
        this.hora = hora;
    }
    
    public int getMinuto(){
        return this.minuto;
    }
    
    public void setMinuto( int minuto){
        this.minuto = minuto;
    }
    
    public int getSegundo(){
        return this.segundo;
    }
    
    public void setSegundo(){
        this.segundo = segundo;
    }
}
