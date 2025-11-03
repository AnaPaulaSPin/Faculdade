import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServicoContadorVisitas extends Remote{

    public String NumeroVisita(String nome) throws RemoteException;

}