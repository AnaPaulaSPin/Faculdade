

public class Estoque {
    private Produto produto;
    private Fornecedor fornecedor;
    private int quantidade;

    public Estoque( Produto produto, Fornecedor fornecedor, int quantidade) {
        this.produto = produto;
        this.fornecedor = fornecedor;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    // O critério de igualdade é se tiver o mesmo código do produto e o mesmo código do fornecedor
    @Override 
    public boolean equals(Object o){
        Estoque e = (Estoque) o;
       if(e.getFornecedor().Getcodigo().equals(this.fornecedor.Getcodigo()) && e.getProduto().Getcodigo().equals(this.produto.Getcodigo())){
        return true;
       }
       return false;
    }
}