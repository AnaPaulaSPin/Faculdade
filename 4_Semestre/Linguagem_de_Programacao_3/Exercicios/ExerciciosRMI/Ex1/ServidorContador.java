import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.atomic.AtomicInteger;

public class ServidorContador extends UnicastRemoteObject implements ServicoContadorVisitas {
    public AtomicInteger contadorVisitas;

    public ServidorContador(AtomicInteger contador)throws RemoteException{
        super();
        this.contadorVisitas = contador;
    }

    public String NumeroVisita(String nome) throws RemoteException{
        return "Ola! " + nome + " voce é o visitante numero: " + contadorVisitas.incrementAndGet();
    }
}
