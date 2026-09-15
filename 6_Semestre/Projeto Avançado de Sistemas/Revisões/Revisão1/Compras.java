import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Compras {
    private Map cProduto = new HashMap(); 
    private Map cFornecedor = new HashMap(); 
    private List<Estoque> cEstoque = new ArrayList(); 

    public boolean adicionaProduto(Produto p){
        return cProduto.put(p.Getcodigo(), p) == null;

    }

    public boolean adicionaFornecedor(Fornecedor f){
        return cFornecedor.put(f.Getcodigo(), f) == null;

    }

    // Caso I: O estoque não existe  
    // Este método deve criar um estoque definindo o seu produto, fornecedor (localizar produtos e fornecedores já cadastrados) e quantidade. Por fim, adicione o estoque na lista. 
    // Caso II: O estoque já existe 
   // Localize o estoque, recupera da lista e incrementa a quantidade 
    public void compra(String codigoProduto, String codigoFornecedor,int qtd){
        Estoque estoque = new Estoque(cProduto.get(codigoProduto), cFornecedor.get(codigoFornecedor), qtd);
        Boolean achado = false;

        for (Estoque e: this.cEstoque) {
            if(estoque.equals(e)){
                e.setQuantidade(e.getQuantidade() + qtd);
                achado = true;
                break;
            } 
        }

        if(!achado){
           this.cEstoque.add(estoque);
        }

    }

    public double quantidadeDeProduto(String codigoProdto ){
        Produto produto = (Produto) this.cProduto.get(codigoProdto);
        double qtd = 0;

        for (Estoque e: this.cEstoque) {
            if(e.getProduto().Getcodigo().equals(produto.Getcodigo())){
                qtd += e.getQuantidade();
            }
        }
        return qtd;
    }

    // Lista os produtos vinculados com o preço*quantidade no estoque
     public String totalPorProduto(){
        String listaProdutos = "";
        double total = 0;

        for(Produto p: this.cProduto.values()){ 
            total = this.quantidadeDeProduto(p.getCodigo());
            if (total != 0) {
                listaProdutos += "Produto: " + p.Getdescricao() + "Total: " + p.Getpreco() * total + "\n";
            } 
        }

        return listaProdutos;

     }

}
