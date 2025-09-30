import java.net.ServerSocket;
import java.util.concurrent.CountDownLatch;

public class ServerInitializer {
    private CountDownLatch latch;

    public ServerInitializer(CountDownLatch latch) {
        this.latch = latch;
    }

    public void waitForInitialization(){
        try {
            ServerSocket servidor = new ServerSocket(1234);
            latch.await();

            this.startServer();

            servidor.accept();


            servidor.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }       
    }

    public void startServer(){
        System.out.println("========================================");
        System.err.println("Servidor Principal Online: Pronto para aceitar conexões (Socket.bind())");
        System.out.println("========================================");

    }

    

    public CountDownLatch getLauch(){
        return this.latch;
    }
}
