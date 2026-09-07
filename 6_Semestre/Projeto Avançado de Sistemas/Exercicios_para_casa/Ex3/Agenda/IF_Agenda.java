package Agenda;

import java.util.Collection;
import Contato.IF_Contato;

public interface IF_Agenda {

    IF_Contato getContato(String telefone);

    boolean adicionaContato(IF_Contato contato);

    boolean removeContato(String telefone);

    Collection<IF_Contato> getListaAgenda();
}