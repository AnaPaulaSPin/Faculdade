import java.net.ServerSocket;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ModuleLoader implements Runnable{
    private String nomeMetodo;
    private int segundos;
    private CountDownLatch latch;

    public ModuleLoader(String nome, int segundos, CountDownLatch latch) {
        this.nomeMetodo = nome;
        this.segundos = segundos;
        this.latch = latch;
    }
    @Override
    public void run(){
        try {
            System.out.println("[CARREGANDO] Módulo de " + this.getNomeMetodo() + " iniciando...\r\n");
            Thread.sleep(this.getSegundos());

            System.out.println("[OK] Módulo de " + this.getNomeMetodo() + " carregado.\r");
            latch.countDown();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public String getNomeMetodo(){
        return this.nomeMetodo;
    }

    public int getSegundos(){
        return this.segundos;
    }
    
}

public class Servidor2 {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(4);
        ExecutorService executor = Executors.newFixedThreadPool(4);
        ModuleLoader confg = new ModuleLoader("Configuração", 6000, latch);
        executor.execute(confg);

        ModuleLoader Conexao = new ModuleLoader("Conexão de Log", 4000, latch);
        executor.execute(Conexao);

        ModuleLoader cache = new ModuleLoader("Cache", 9000, latch);
         executor.execute(cache);

        ModuleLoader cripg = new ModuleLoader("Chaves de Criptografia", 12000, latch);
        executor.execute(cripg);

        
        

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
