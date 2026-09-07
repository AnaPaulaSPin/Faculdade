package Agenda;

import Contato.Contato;
import Contato.IF_Contato;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class AgendaList implements IF_Agenda {
  private List<IF_Contato> listaContato = new ArrayList<>();

  public int localizaContato(String telefone){
      Contato contato = new Contato();
      contato.setTelefone(telefone);

      return this.listaContato.indexOf(contato);

    }

  @Override
   public IF_Contato getContato(String telefone){
        return listaContato.get(localizaContato(telefone));
    }
    
    @Override
    public boolean adicionaContato(IF_Contato contato){
      for (IF_Contato cont: this.listaContato){
        if(cont.equals(contato)){
          return false;
        }
      }
      return this.listaContato.add(contato);
    }
    
    @Override
    public boolean removeContato(String telefone){
      int posicao = localizaContato(telefone);
      if(posicao == -1){
        return false;
      } else{
        return this.listaContato.remove(this.listaContato.get(posicao));
      }
    }
    
    @Override
    public String toString(){
      String lista = "";
      Iterator<IF_Contato> iterator = listaContato.iterator();

      while (iterator.hasNext()) {
        IF_Contato contato = iterator.next();
        lista += "Nome: " + contato.getNome() + "\nTelefone: " + contato.getTelefone();

      }
      return lista;
    }
    
    @Override
    public Collection<IF_Contato> getListaAgenda(){
      return this.listaContato;
    }
}
