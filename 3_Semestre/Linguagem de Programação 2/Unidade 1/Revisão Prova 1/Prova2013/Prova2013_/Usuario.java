import java.util.ArrayList;

public class Usuario {
  private String Login;
  private String senha;
  private int data;
  private ArrayList<Aplicativo> apps;
  
  public Usuario(String login, String senha, int data){
      this.Login = login;
      this.senha = senha;
      this.data = data;
      this.apps = new ArrayList<>();
  }
  
  
    public String getLogin() {
        return Login;
    }
    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }

    public ArrayList<Aplicativo> getApps() {
        return apps;
    }
    
    public void addApps(Aplicativo app) {
        this.apps.add(app);
    }
  
  
}
