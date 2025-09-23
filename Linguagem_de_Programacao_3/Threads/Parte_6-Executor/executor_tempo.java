import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class executor_tempo {
    public static void main(String[] args) throws InterruptedException {
       ExecutorService executor = null;
       try {
          executor = Executors.newSingleThreadExecutor();
          executor.execute(new MeuRunnable());
          executor.awaitTermination(5, TimeUnit.SECONDS);
       } catch (Exception e) {
           throw e;
       } finally {
          if (executor != null) {
          executor.shutdown();
          } 
         }
       }

public static class MeuRunnable implements Runnable {
      public void run() {
         String nome = Thread.currentThread().getName();
         System.out.println(nome + ": LP-III");
       }
    } 
}
