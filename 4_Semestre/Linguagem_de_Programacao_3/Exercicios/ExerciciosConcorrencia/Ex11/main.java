import java.lang.reflect.Executable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class main {
    static contador i = new contador();
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        Runnable tarefa = () -> {
            synchronized(i){

                i.incrementar();
                System.out.print(i.getContador() + " ");
            }
        };

        for(int i = 1; i < 1000; i++){
            executor.submit(tarefa);
        }

        executor.shutdown();
    }
}
