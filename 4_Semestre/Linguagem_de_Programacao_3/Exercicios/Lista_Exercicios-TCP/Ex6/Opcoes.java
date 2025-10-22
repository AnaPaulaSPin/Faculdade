import java.io.Serializable;

public class Opcoes implements Serializable {
    String opcao1;
    String opcao2;
    String opcao3;
    String opcao4;

    public Opcoes(String opcao1, String opcao2, String opcao3, String opcao4){
        this.opcao1 = opcao1;
        this.opcao2 = opcao2;
        this.opcao3 = opcao3;
        this.opcao4 = opcao4;
    }

    public String getOpcao1(){
        return this.opcao1;
    }

    public void setOpcao1(String opcao){
        this.opcao1 = opcao;
    }

    public String getOpcao2(){
        return this.opcao2;
    }

    public void setOpcao2(String opcao){
        this.opcao2 = opcao;
    }

    public String getOpcao3(){
        return this.opcao3;
    }

    public void setOpcao3(String opcao){
        this.opcao3 = opcao;
    }

    public String getOpcao4(){
        return this.opcao4;
    }

    public void setOpcao4(String opcao){
        this.opcao4 = opcao;
    }
}
