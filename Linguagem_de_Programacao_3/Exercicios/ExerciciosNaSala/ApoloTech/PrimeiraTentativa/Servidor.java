import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Servidor{
    static CountDownLatch latch = new CountDownLatch(4);

    public static void main(String[] args) {
        Runnable configuracao =() -> { 
        try {
            System.out.println("[CARREGANDO] Módulo Conexão de Log iniciando...\r\n");
            Thread.sleep(6000);

            System.out.println("[OK] Módulo Configuração carregado.\r");
            latch.countDown();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    };

    Runnable cache =() -> { 
        try {
            System.out.println("[CARREGANDO] Módulo Cache iniciando...\r\n");
            Thread.sleep(9000);

            System.out.println("[OK] Módulo Cache carregado.\r");
            latch.countDown();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    };

    Runnable Criptografia =() -> { 
        try {
            System.out.println("[CARREGANDO] Módulo Chaves de Criptografia iniciando...\r\n");
            Thread.sleep(12000);

            System.out.println("[OK] Módulo Chaves de Criptografia carregado.\r");
            latch.countDown();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    };

    Runnable  ConexãoLog =() -> { 
        try {
            System.out.println("[CARREGANDO] Módulo Conexão de Log iniciando...\r\n");
            Thread.sleep(4000);

            System.out.println("[OK] Módulo Conexão de Log carregado.\r");
            latch.countDown();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    };
        
    ExecutorService executor = Executors.newFixedThreadPool(4);
        executor.execute(configuracao);
        executor.execute(cache);
        executor.execute(Criptografia);
        executor.execute(ConexãoLog);


        try {
            ServerSocket servidor = new ServerSocket(1234);
            latch.await();

            System.out.println("========================================");
            System.err.println("Servidor Principal Online: Pronto para aceitar conexões (Socket.bind())");
            System.out.println("========================================");
            servidor.accept();


            servidor.close();
            executor.shutdown();
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }         
        
    }

    
}