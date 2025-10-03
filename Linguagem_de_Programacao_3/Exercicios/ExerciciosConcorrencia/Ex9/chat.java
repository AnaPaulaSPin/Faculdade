import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


public class chat{
    static LinkedBlockingQueue<String> ListMensagens = new LinkedBlockingQueue<>();
    static AtomicInteger i = new AtomicInteger(0);
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(4);

        Runnable mensagens = () -> {
        ListMensagens.add("Usuario " + i.incrementAndGet() + ": Oiiiii");

        };

        executor.scheduleAtFixedRate(mensagens, 0, 1, TimeUnit.SECONDS);


        int segundos = 4000;
        while(segundos != 0){

          try {
             Thread.sleep(segundos);

          } catch (Exception e) {
             e.printStackTrace();
         }

         int total = ListMensagens.size();
         for(int j = 0; j < total;j++){
            try {
                String msg = ListMensagens.take();
                System.out.println(msg);

            } catch (Exception e) {
                e.printStackTrace();
            }

         }
         System.out.println();

         segundos = segundos - 1000;
        }

        executor.shutdown();






        
    }
}