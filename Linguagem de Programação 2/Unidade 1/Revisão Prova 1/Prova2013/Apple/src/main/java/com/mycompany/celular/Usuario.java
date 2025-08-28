
package com.mycompany.celular;

import java.util.ArrayList;

public class Usuario {
  private String Login;
  private String senha;
  private int data;
  private ArrayList<Aplicativos> apps;
  
  public Usuario(String login, String senha, int data){
      this.Login = login;
      this.senha = senha;
      this.data = data;
      this.apps = new ArrayList<>();
  }
  
  public float gasto(){
        float total = 0;
        for(Aplicativos meuapp: apps){
            total += meuapp.getPreco();
        }
        return total;
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
    
      public ArrayList<Aplicativos> getApps() {
        return apps;
    }
    
    public void addApps(Aplicativos app) {
        this.apps.add(app);
    }
  
  
}
