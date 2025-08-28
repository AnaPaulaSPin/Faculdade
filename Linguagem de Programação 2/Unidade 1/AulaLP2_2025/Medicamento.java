public class Medicamento
{
    private String nome,principioAtivo;
    private float precoCusto;
    private Fabricante produtor; 
    
    
    public Medicamento(String nome, String principioAtivo, float precoCusto, Fabricante produtor){
        this.nome = nome;
        this.principioAtivo = principioAtivo;
        this.precoCusto = precoCusto;
        this.produtor = produtor;
    }
    public Medicamento(String nome, float precoCusto){
        this(nome,nome,precoCusto,null);
         
    }
    
    public boolean generico(Medicamento outro){
        if (this.principioAtivo.equals(outro.getPrincipioAtivo()))
           return true;
        else
           return false;
    }
    
    
    public void setProdutor(Fabricante produtor)
    {
        this.produtor = produtor;
    }
    public Fabricante getProdutor(){
        return this.produtor;
    }
    public float calcPrecoVenda(float percentual){
        return this.precoCusto + this.precoCusto*percentual/100;
    }
    public float calcPrecoVenda(){
        float perc;
        perc = produtor.getPercLucro();
        
       return this.calcPrecoVenda(perc);
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setPrincipioAtivo(String principioAtivo){
        this.principioAtivo = principioAtivo;
    }
    public void setNome(float precoCusto){
        this.precoCusto = precoCusto;
    }
    public String getNome(){
        return this.nome;
    }
    public String getPrincipioAtivo(){
        return this.principioAtivo;
    }
    public float getPrecoCusto(){
        return this.precoCusto;
    }
}
