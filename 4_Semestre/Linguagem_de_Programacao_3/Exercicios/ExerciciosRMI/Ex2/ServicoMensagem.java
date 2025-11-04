import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ServicoMensagem  extends UnicastRemoteObject implements ServidorMensagem{
    public List<String> mensagens;

    protected ServicoMensagem(List<String> mensagens) throws RemoteException{
        super();
        this.mensagens = mensagens;
        
    }

    public List<String> addMensagem(String nome,String mensagem)throws RemoteException{
        mensagens.add("["  + nome + "]: " + mensagem);

        return mensagens;
    }

}