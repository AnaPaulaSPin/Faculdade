
public class Fabricante
{
    private int cnpj;
    private String nomeFantasia, endereco;
    private float percLucro;
    public Fabricante(int cnpj, String nomeFantasia, String endereco, float percLucro){
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
        this.endereco = endereco;
        this.percLucro = percLucro;
    }
    
    public void setPercLucro(float percLucro){
        this.percLucro = percLucro;
    }
    public float getPercLucro(){
        return percLucro;
    }
}
