import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Pedidos {
    private static LinkedBlockingQueue<String> produtos = new LinkedBlockingQueue<>();
    private static int i = 0;
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
        

        Runnable produtora = () -> {

                synchronized(produtos){
                 i++;
                 System.out.println("Criando um produto " + i);
                 String produto ="Produto" + i;
                 produtos.add(produto);
                }

        };

        executor.scheduleAtFixedRate(produtora, 0, 1, TimeUnit.SECONDS);

        Runnable consumidora = () -> {
           
           try {
                 System.out.println("retirando o produto " + produtos.take());
                
            } catch (Exception e) {
                e.printStackTrace();
            }

        };
       while(true){
        executor.submit(consumidora);
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

       }
        
    }

}
