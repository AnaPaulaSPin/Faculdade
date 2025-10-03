import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(4);
        ExecutorService executor = Executors.newFixedThreadPool(4);
        
        ServerInitializer server = new ServerInitializer(latch);


        ModuleLoader confg = new ModuleLoader("Configuração", 6000, latch);
        executor.execute(confg);

        ModuleLoader Conexao = new ModuleLoader("Conexão de Log", 4000, latch);
        executor.execute(Conexao);

        ModuleLoader cache = new ModuleLoader("Cache", 9000, latch);
         executor.execute(cache);

        ModuleLoader cripg = new ModuleLoader("Chaves de Criptografia", 12000, latch);
        executor.execute(cripg);


        executor.shutdown();      
    }
}




