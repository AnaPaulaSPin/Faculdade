import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Servidor{
    private static List<PrintWriter> clients = new CopyOnWriteArrayList<>();
    static ExecutorService executor = Executors.newCachedThreadPool();
    static AtomicInteger vencedor = new AtomicInteger();
    static Lance lanceAtual = new Lance(null, 0, 0);
    public static void main(String[] args) {
        try {
            ServerSocket leilao = new ServerSocket(1234);
            ServerSocket comuniSocket = new ServerSocket(3454);

            System.out.println("Leilão ativo!");

            while(vencedor.get() == 0 ){
                Socket comuniSocket2 = comuniSocket.accept();
                Socket cliente = leilao.accept();
                executor.submit(new SistemaLance(lanceAtual,cliente,clients,vencedor,comuniSocket2));
            }

            leilao.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
  }

  public static void broadcast(String msg){
        for(PrintWriter user: clients){
            try {
                user.print(msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

 
}