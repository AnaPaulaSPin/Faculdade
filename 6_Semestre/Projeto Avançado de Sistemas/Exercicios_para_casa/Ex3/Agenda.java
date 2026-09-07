

import java.util.*;

import Contato.*;
import FabricaAgenda.FabricaAgenda;

public abstract class Agenda {

    public abstract boolean adicionaContato(IF_Contato contato);

    public abstract boolean removeContato(String telefone);

    public abstract IF_Contato getContato(String telefone);

    public abstract Collection getLista();

    public String listaContato() {
        String lista = "";

        Iterator iterator = getLista().iterator();

        while (iterator.hasNext()) {
            IF_Contato contato = (IF_Contato) iterator.next();

            lista += "Nome: " + contato.getNome()
                    + "\nTelefone: " + contato.getTelefone() + "\n";
        }

        return lista;
    }

   public String listaContatoIniciais(String iniciais) {

    String lista = "";

    Iterator iterator = getLista().iterator();

    while (iterator.hasNext()) {

        IF_Contato contato = (IF_Contato) iterator.next();

        if (contato.getNome().startsWith(iniciais)) {
            lista += "Nome: " + contato.getNome()
                    + "\nTelefone: " + contato.getTelefone() + "\n";
        }
    }

    return lista;
}
}

class AgendaList extends Agenda {
  // implemente com ArrayList
private ArrayList<IF_Contato> listaAgenda = new ArrayList<>();

  public int localizaContato(String telefone){
      Contato contato = new Contato();
      contato.setTelefone(telefone);

      return this.listaAgenda.indexOf(contato);

    }

  @Override
   public IF_Contato getContato(String telefone){
        return listaAgenda.get(localizaContato(telefone));
    }
    
@Override
public boolean adicionaContato(IF_Contato contato) {

    for (IF_Contato cont : this.listaAgenda) {
        if (cont.equals(contato)) {
            return false;
        }
    }

    return this.listaAgenda.add(contato);
}
    
    @Override
    public boolean removeContato(String telefone){
      int posicao = localizaContato(telefone);
      if(posicao == -1){
        return false;
      } else{
        return this.listaAgenda.remove(this.listaAgenda.get(posicao));
      }
    }
    
    @Override
    public String toString(){
      String lista = "";
      Iterator<IF_Contato> iterator = listaAgenda.iterator();

      while (iterator.hasNext()) {
        IF_Contato contato = iterator.next();
        lista += "Nome: " + contato.getNome() + "\nTelefone: " + contato.getTelefone();

      }
      return lista;
    }
    
    @Override
    public Collection<IF_Contato> getLista(){
      return this.listaAgenda;
    }
}

class AgendaMap extends Agenda {
  // implemente com HashMap
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
  
  @Override
  public Collection<IF_Contato> getLista(){
    return this.listaContato.values();
  }
}

class MainTesteFabrica {
  public static void main(String[] args) {
    Agenda agenda = FabricaAgenda.getInstancia().criaAgenda(FabricaAgenda.AGENDALIST);
    IF_Contato[] contatos = new IF_Contato[3];

    contatos[0] = new Contato();
    contatos[0].setNome("A");
    contatos[0].setTelefone("345-2455");
    System.out.println("Adicionando " + contatos[0]);
    agenda.adicionaContato(contatos[0]);

    contatos[1] = new Contato();
    contatos[1].setNome("X");
    contatos[1].setTelefone("234-9085");
    System.out.println("Adicionando " + contatos[1]);
    agenda.adicionaContato(contatos[1]);

    contatos[2] = new Contato();
    contatos[2].setNome("Y");
    contatos[2].setTelefone("8890-19085");
    System.out.println("Adicionando " + contatos[2]);
    agenda.adicionaContato(contatos[2]);

    System.out.println(agenda);
    System.out.println("Localizando 345-2455");
    System.out.println(agenda.getContato("345-2455"));
    System.out.println("Removendo 234-9085");
    agenda.removeContato("234-9085");
    System.out.println(agenda);
  }
}