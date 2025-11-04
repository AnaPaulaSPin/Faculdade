import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ServidorMensagem extends Remote {
    List<String> addMensagem(String nome, String mensagem) throws RemoteException;
    
    
}