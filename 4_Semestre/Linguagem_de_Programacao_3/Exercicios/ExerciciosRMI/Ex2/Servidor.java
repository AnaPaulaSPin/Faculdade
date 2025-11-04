import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Servidor {

    protected Servidor() throws RemoteException{
        super();
    }

    static public List<String> mensagens = Collections.synchronizedList(new ArrayList<String>());
    public static void main(String[] args) throws RemoteException {
        ServicoMensagem servico = new ServicoMensagem(mensagens);
        Registry registro = LocateRegistry.createRegistry(1099);
        registro.rebind("mandarMensagens", servico);
        System.out.println("Servidor iniciado!");
    }
}
