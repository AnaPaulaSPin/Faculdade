
public class Medicamento
{
    private String nome;
    private String principioAtivo;
    private float precoCusto;
    private fabricante produtor;
    
    public Medicamento(String nome, String principioAtivo, float precoCusto, fabricante produtor){
        this.nome = nome;
        this.principioAtivo = principioAtivo;
        this.precoCusto = precoCusto;
        this.produtor = produtor;
    }
    
    public Medicamento(String nome, float precoCusto){
        this(nome,nome,precoCusto,null);
    }
    
    //sets e gets
    public void setProdutor(fabricante produtor){
        this.produtor = produtor;
    }
    
    public fabricante getProdutor(){
        return this.produtor;
    
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setPrincipioAtivo(String principioAtivo){
        this.principioAtivo = principioAtivo;
    }
    
    public String getPrincipioAtivo(){
        return this.principioAtivo;
    } 
    
    public void setPrecoCusto(float precoCusto){
        this.precoCusto = precoCusto;
    }
    
    public float getPrecoCusto(){
        return this.precoCusto;
    }
    
    //Metodos:
    public boolean generico(Medicamento outro1 ){
        if(this.getPrincipioAtivo() == outro1.getPrincipioAtivo()){
            return true;
        } else 
           return false;
        
    }
    
    
    public float calcularLucro(float precoVenda){
        precoVenda = precoVenda / 100;
        
        precoVenda = this.precoCusto * precoVenda;
        return precoCusto;
        
    }
    
    public float calcularLucro(){
        float perc;
        perc = produtor.getPercLucro();
        return this.calcularLucro(perc);
        
    }
    
}
