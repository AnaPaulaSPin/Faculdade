import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.concurrent.atomic.AtomicInteger;

public class Servidor {
    public static void main(String[] args) {
        AtomicInteger contador = new AtomicInteger(0);
        try {
            
            ServidorContador obj = new ServidorContador(contador);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("ContadorServicos", obj);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
