import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Estacionamento {
    private static Semaphore semaforo = new Semaphore(3);

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        Runnable estacionar = () -> {
            try {
                semaforo.acquire();
                System.out.println(Thread.currentThread().getName() + " Entrou para estacionar.");
                Thread.sleep(2000);

                System.out.println("\n" + Thread.currentThread().getName() + " Saiu do estacionamento.");
                System.out.println("=============================================================");
                semaforo.release();
                
            } catch (Exception e) {
                e.printStackTrace();
            }

        };

        for(int i =0; i < 10; i++){
            executor.submit(estacionar);
        }

        executor.shutdown();

    }

    
}