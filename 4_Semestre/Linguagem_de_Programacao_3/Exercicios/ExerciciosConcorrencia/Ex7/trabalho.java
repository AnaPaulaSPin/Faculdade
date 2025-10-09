import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class trabalho {
    private static CyclicBarrier barreira = new CyclicBarrier(4);
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Runnable funcionario = () -> {
            System.out.println("Funcionario: " + Thread.currentThread().getName() + " chegou ao trabalho!" );
            try {
                Thread.sleep(2000);
                barreira.await();

            } catch (Exception e) {
                e.printStackTrace();
            }
            

            System.out.println("Todos chegaram, vamos trabalhar!");
        };

        executor.submit(funcionario);
        executor.submit(funcionario);
        executor.submit(funcionario);
        executor.submit(funcionario);
        executor.shutdown();

        
        
    }
}
