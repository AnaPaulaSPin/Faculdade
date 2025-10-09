
public class Ligacao
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private String localOrg;
    private int numero_origem;
    
    private String localDest;
    private int numero_destino;
    
    private float valoTotal;
    private Tempo momentoInicio;
    private Tempo momentoFim;
    
    /**
     * Construtor para objetos da classe Ligacao
     */
    public Ligacao( Tempo momentoInicio, String localOrg, int numero_origem, String localDest, int numero_destino)
    {   
        this.momentoInicio = momentoInicio;
        this.localOrg = localOrg;
        this.numero_origem = numero_origem;
        
        this.localDest = localDest;
        this.numero_destino = numero_destino;
        
    }

    
    public String Localidade(int num) {
        return "bahia";
    }
    
    public String getLocalOrg(){
         return this.localOrg;
     }
     
    public void setLocalOrg(String localOrg){
         this.localOrg = localOrg;
     }
     
    public int getNumero_origem(){
        return this.numero_origem;
      }
    
    public void setNumero_origem(int numero_origem){
        this.numero_origem = numero_origem;
      }
      
    public String getLocalDest(){
        return this.localDest;
         
     }
     
    public void setLocalDest(String localDest){
        this.localDest = localDest;
         
     }
    
    
    public int getNumero_destino(){
        return this.numero_destino;
    }
    
    public void setNumero_destino(int numero_destino){
        this.numero_destino = numero_destino;
         
     }
    
    public float getValo_Total(){
        return this.valoTotal;
    }
    
    public void setValo_Total(float valo_Total){
        this.valoTotal = valo_Total;
         
     }
    
    public Tempo getMomentoInicio(){
        return this.momentoInicio;
    }
    
    public void setMomentoInicio(Tempo momentoInicio){
        this.momentoInicio = momentoInicio;
         
     }
    
    public Tempo getMomentoFim(){
        return this.momentoFim;
    }
    
    public void setMomentoFim(Tempo momentoFim){
        this.momentoFim = momentoFim;
     }
    
}
