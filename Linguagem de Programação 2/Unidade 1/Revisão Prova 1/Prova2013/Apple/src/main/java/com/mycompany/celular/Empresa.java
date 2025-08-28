
package com.mycompany.celular;

import java.util.ArrayList;

public class Empresa {
    private String nome;
    private final ArrayList<Usuario> users;
    private final ArrayList<Aplicativos> apps;
    
    public Empresa(String nome){
        this.nome = nome;
        this.apps = new ArrayList<>();
        this.users = new ArrayList<>();
    }
    
    //equals
    public boolean reduzConta(Usuario user){
        //Lista do user:
        for(Aplicativos meusApp: user.getApps()){
            //Lista da empresa:
            for(Aplicativos appEmpresa: apps){
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
        
        for(Aplicativos appEmpr: apps){
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
    
    public ArrayList<Aplicativos> getApps() {
        return apps;
    }
    
    public void addApps(Aplicativos app) {
        this.apps.add(app);
    }
    
    public ArrayList<Usuario> getUsers() {
        return users;
    }
    
    public void addUsers(Usuario user) {
        this.users.add(user);
    }
    
    
}
