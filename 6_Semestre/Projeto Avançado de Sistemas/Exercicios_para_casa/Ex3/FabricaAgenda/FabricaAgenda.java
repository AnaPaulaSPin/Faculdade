package FabricaAgenda;

import Agenda.*;

public class FabricaAgenda {
  public static final int AGENDAMAP=0, AGENDALIST=1;
  public static FabricaAgenda fabricaAgenda = new FabricaAgenda();

  private FabricaAgenda() {
  }

  public static FabricaAgenda getInstancia() {
    return fabricaAgenda;
  }

  public IF_Agenda criaAgenda(int tipo) {
    if (tipo == AGENDAMAP) {
      return new AgendaMap();
    } else if (tipo == AGENDALIST) {
      return new AgendaList();
    } else {
      return null;
    }
  }
  // Aplique Singleton e Factory Method
}


