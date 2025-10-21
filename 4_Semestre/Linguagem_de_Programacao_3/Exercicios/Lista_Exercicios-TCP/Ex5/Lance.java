import java.io.Serializable;

public class Lance implements Serializable {
    public String nome;
    public int valor;
    public int sinal; //simboliza se esse é o lance definitivo ou nao

    public Lance(String nome, int valor, int sinal){
        this.nome = nome;
        this.valor = valor;
        this.sinal = sinal;
    }

    public String getNome(){
        return nome;
    }

    public int getValor(){
        return valor;
    }

    public void setValor(int valor){
        this.valor = valor;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setSinal(int sinal){
        this.sinal = sinal;

    }

    public int getSinal(){
        return this.sinal;
    }

}
