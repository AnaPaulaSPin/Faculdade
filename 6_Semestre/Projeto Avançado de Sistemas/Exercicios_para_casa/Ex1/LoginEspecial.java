

public class LoginEspecial extends Login{
    private String dica;
    public LoginEspecial(String nome, String senha, String dica){
        super(nome, senha);
        this.dica = dica;
    }

    public String getDica(){
        return this.dica;
    }
}
