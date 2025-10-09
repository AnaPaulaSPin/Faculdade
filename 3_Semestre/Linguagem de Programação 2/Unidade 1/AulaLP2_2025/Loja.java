
/**
 * Escreva uma descrição da classe Loja aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Loja
{
    private String nomeFantasia,razaoSocial;
    private int numCnpj,digCnpj;
    private float faturamento,area;
    private String publicoAlvo;
    
    public Loja(String nomeFantasia, String razaoSocial, int numCnpj, int digCnpj){
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.numCnpj = numCnpj;
        this.digCnpj = digCnpj;
    }
    public Loja(String nomeFantasia, int numCnpj, int digCnpj, float faturamento, String publicoAlvo){
        this(nomeFantasia,nomeFantasia,numCnpj, digCnpj);
        this.faturamento = faturamento;
        this.publicoAlvo = publicoAlvo;
    }
    public float calcularAluguel(){
        return this.area *50;
    }
    public void setNomeFantasia(String nomeFantasia){
        this.nomeFantasia=nomeFantasia;
    }
    public void setRazaoSocial(String razaoSocial){
        this.razaoSocial=razaoSocial;
    }
    public void setNumCnpj(int numCnpj){
        this.numCnpj=numCnpj;
    }
    public void setDigCnpj(int digCnpj){
        this.digCnpj=digCnpj;
    }
    public void setFaturamento(float faturamento){
        this.faturamento=faturamento;
    }
    public void setArea(int area){
        this.area=area;
    }
    public void setPublicoAlvo(String publicoAlvo){
        this.publicoAlvo = publicoAlvo;
    }
    public String getNomeFantasia(){
        return this.nomeFantasia;
    }
    public String getRazaoSocial(){
        return this.razaoSocial;
    }
    public int getNumCnpj(){
        return this.numCnpj;
    }
    public int getDigCnpj(){
        return this.digCnpj;
    }
    public float getFaturamento(){
        return this.faturamento;
    }
    public float getArea(){
        return this.area;
    }
    public String getPublicoAlvo(){
        return this.publicoAlvo;
    }
    
    
}
