package Agenda;

import java.util.*;

import Contato.IF_Contato;

public class AgendaMap implements IF_Agenda {
  // implemente usando HashMap
  private Map<String, IF_Contato> listaContato = new HashMap<String, IF_Contato>();


   public IF_Contato getContato(String telefone){
    return listaContato.get(telefone);

   }

  public boolean adicionaContato(IF_Contato contato){
    if(listaContato.containsKey(contato.getTelefone())){
      return false;
    } else{
      this.listaContato.put(contato.getTelefone(), contato);
      return true;
    }
  }

  public boolean removeContato(String telefone){
    if(listaContato.containsKey(telefone) ){
      IF_Contato contatoRemovido = listaContato.remove(telefone);
      if(contatoRemovido == null){
       return false;
      } else{
       return true;
      }  
    }
    return false;
    
  }

  public String toString(){
    Iterator<IF_Contato> iterator = listaContato.values().iterator();
    String lista = " ";

    while(iterator.hasNext()){
      lista += "Nome: " + iterator.next().getNome() + "\nTelefone: " + iterator.next().getTelefone();
    }

    return lista;
  }

  public Collection<IF_Contato> getListaAgenda(){
    return this.listaContato.values();

  }
}

