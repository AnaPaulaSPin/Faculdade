import java.util.ArrayList;

public class Empresa {
    private String nome;
    private ArrayList<Usuario> users;
    private ArrayList<Aplicativo> apps;
    
    public Empresa(String nome){
        this.nome = nome;
        this.apps = new ArrayList<>();
        this.users = new ArrayList<>();
    }
    
    //equals
    public boolean reduzConta(Usuario user){
        //Lista do user:
        for(Aplicativo meusApp: user.getApps()){
            //Lista da empresa:
            for(Aplicativo appEmpresa: apps){
            if(!meusApp.getNome().equals(appEmpresa.getNome()) && meusApp.subsituirAplicativo(appEmpresa)){
                return true;
            }
        }
        }
        return false;
    }
    
    public String maisUsers(){
        int maior = 0;
        String nome = null;
        
        for(Aplicativo appEmpr: apps){
            if(maior < appEmpr.getUsers().size()){
                maior = appEmpr.getUsers().size();
                nome = appEmpr.getNome();
            }
        }
        return nome;
    }


    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }


     public ArrayList<Usuario> getUsers() {
        return users;
    }
    
    public void addUsers(Usuario user) {
        this.users.add(user);
    }

    
    public ArrayList<Aplicativo> getApps() {
        return apps;
    }
    
    public void addApps(Aplicativo app) {
        this.apps.add(app);
    }
    
    
}
