public class Livro
{
    String nome, autor,edicao;
    int ano;
    double precoVenda;
    
    void criarLivro(String nome, String autor, String edicao, int ano, double precoVenda){
        this.nome = nome;
        this.autor = autor;
        this.edicao = edicao;
        this.ano = ano;
        this.precoVenda = precoVenda;
        this.precoVenda = this.calculaPreco(20);
        
    }
    
    void ImprimirLivro(){
        System.out.println("Livro: " + this.nome);
        System.out.println("Autor: " + this.autor);
        System.out.println("Ano de Lancamento: " + this.ano);
        System.out.println("edicao: " + this.edicao);
        System.out.println("Preco: " + this.precoVenda);
        
    }
    
    double calculaPreco(double percentual){
        double preco;
        
        percentual = percentual / 100;
        
        percentual = percentual * this.precoVenda;
        
        preco = percentual + this.precoVenda;
        
        return preco;
    }
}

