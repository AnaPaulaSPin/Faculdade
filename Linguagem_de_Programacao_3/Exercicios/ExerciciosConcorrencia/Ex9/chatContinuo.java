import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class chatContinuo {
    static LinkedBlockingQueue<String> ListMensagens = new LinkedBlockingQueue<>();
    static AtomicInteger i = new AtomicInteger(0);
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(4);

        Runnable mensagens = () -> {
        ListMensagens.add("Usuario " + i.incrementAndGet() + ": Oiiiii");

        };

        executor.scheduleAtFixedRate(mensagens, 0, 1, TimeUnit.SECONDS);

        while(true){

         String msg = "Teste";
         while(msg != null){
            try {
                 msg = ListMensagens.take();
                System.out.println(msg);

            } catch (Exception e) {
                e.printStackTrace();
            }
         }
        }

        
  }
}
