public class ProdutoPerecivel extends Produto{
    private int validade;
    private String formaArmazen;
    
    public float precoVenda(float preco){
        
        return preco;
    }
    
    public ProdutoPerecivel(int codigo, String nome,  float preco, int validade,String formaArmazen ){
        super(codigo,nome,preco);
    }

    public int getValidade() {
        return validade;
    }

    public void setValidade(int validade) {
        this.validade = validade;
    }

    public String getFormaArmazen() {
        return formaArmazen;
    }

    public void setFormaArmazen(String formaArmazen) {
        this.formaArmazen = formaArmazen;
    }
    
    
}