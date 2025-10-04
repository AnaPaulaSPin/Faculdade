import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Estacionamento{
    static AtomicInteger contador = new AtomicInteger(0);
    static Random random = new Random();
    static Semaphore entrada = new Semaphore(1);
    static Semaphore saida = new Semaphore(1);
    static Semaphore prioridade = new Semaphore(2);
    static Semaphore normal = new Semaphore(5);
    static AtomicInteger qtdPrio = new AtomicInteger(6);
    static AtomicInteger qtdNormal = new AtomicInteger(14);

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        

        for(int i = 0; i < 20; i++){
            int tipo = random.nextInt(2);
            Veiculo veiculo = new Veiculo(tipo, contador.incrementAndGet() + nome(tipo), entrada, saida, prioridade, normal);
            executor.submit(veiculo.tarefa);


        }

        executor.shutdown();
        


    }

    public static String nome(int tipo){
    
        
        if(tipo == 1 && qtdPrio.get() != 0 ){
            qtdPrio.decrementAndGet();
            return "° Veiculo(Prioritario)";

        } else if( qtdPrio.get() == 0){
            qtdNormal.decrementAndGet();
            return "° Veiculo(Normal)";

        } else if(tipo != 1 && qtdNormal.get() != 0){
            qtdNormal.decrementAndGet();
            return "° Veiculo(Normal)";

        } else{
            qtdPrio.decrementAndGet();
            return "° Veiculo(Prioritario)";
        }
    }
}