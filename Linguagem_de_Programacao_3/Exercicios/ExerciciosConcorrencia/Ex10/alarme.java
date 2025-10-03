import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class alarme {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable alarme = () -> System.out.println(" Alarme tocando");

        for(int i = 0; i < 5; i++){
            executor.scheduleAtFixedRate(alarme, 5, 5, TimeUnit.SECONDS);
        }

        executor.shutdown();
    
 
    }

}

