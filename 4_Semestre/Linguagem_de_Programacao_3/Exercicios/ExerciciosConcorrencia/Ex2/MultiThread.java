import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThread {
    static int i = 1;
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Runnable tarefa = () -> System.out.println(Thread.currentThread().getName() + ": i = " + i++);

        executor.submit(tarefa);
        executor.submit(tarefa);
        executor.submit(tarefa);
        executor.submit(tarefa);
        executor.submit(tarefa);
        executor.submit(tarefa);
        executor.submit(tarefa);
        executor.submit(tarefa);
        executor.submit(tarefa);
        executor.submit(tarefa);

        executor.shutdown();

    }
}
