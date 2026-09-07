package Contato;

public class Contato implements IF_Contato {
  private String nome;
  private String telefone;
  
  @Override 
  public String getNome(){
    return this.nome;

  } 

  @Override 
  public String getTelefone(){
    return this.telefone;
  }

  @Override 
  public void setNome(String nome){
    this.nome = nome;
  }
  @Override 
  public void setTelefone(String telefone){
    this.telefone = telefone;
  }

  @Override 
  public String toString(){
    return "Nome: " + this.nome + "\nTelefone: " + this.telefone;
  }
  
  @Override
  public boolean equals(Object o){
   Contato contato = (Contato) o;
    return this.getTelefone().equals(contato.getTelefone());
  }


}
