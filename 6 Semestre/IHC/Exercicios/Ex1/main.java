

public class main {
    public static void main(String[] args) {
        Login login = new Login("eduardo", "123");

        System.out.println( "Nome: "+ login.nome + " Senha:" + login.senha);

        LoginEspecial loginEspecial = new LoginEspecial(login.nome, login.senha, "Sequencia numerica");

        System.out.println(loginEspecial.getDica());
    }
}
