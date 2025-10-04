import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Estacionamento{
    // variaveis globais
    static AtomicInteger contador = new AtomicInteger(0); // para contar a quantidade de carros
    static Random random = new Random(); // aleatorizar os numeros
    static Semaphore entrada = new Semaphore(1); // permissão de quantos carros podem entrar por vez
    static Semaphore saida = new Semaphore(1); // permissão de quantos carros podem sair por vez
    static Semaphore prioridade = new Semaphore(2); // Quantas vagas de prioridade
    static Semaphore normal = new Semaphore(5); // Quantas vagas normais.
    static CountDownLatch terminado = new CountDownLatch(20);

    static List<Future<informacoes>> resultados = new ArrayList<>();

    // varivaies para controlar a quantidade de vagas criadas:
    static AtomicInteger qtdPrio = new AtomicInteger(6); 
    static AtomicInteger qtdNormal = new AtomicInteger(14);
    

    //Controle de estatisticas:
    static AtomicInteger carrosEntraram = new AtomicInteger(0); //carros que entraram

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        

        for(int i = 0; i < 20; i++){
            int tipo = random.nextInt(2);
            Veiculo veiculo = new Veiculo(tipo, contador.incrementAndGet() + nome(tipo), entrada, saida, prioridade, normal,terminado);
            resultados.add(executor.submit(veiculo.tarefa));

        }

        try {
            terminado.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        status();
        estasticasFinais();
        executor.shutdown();
        


    }

    public static String nome(int tipo){
        
        if(tipo == 1 && qtdPrio.get() != 0 ){
            qtdPrio.decrementAndGet();
            return "° Veiculo(Prioritario)";

        } else if( qtdPrio.get() == 0){
            qtdNormal.decrementAndGet();
            tipo = 0;
            return "° Veiculo(Normal)";

        } else if(tipo != 1 && qtdNormal.get() != 0){
            qtdNormal.decrementAndGet();
            return "° Veiculo(Normal)";

        } else{
            qtdPrio.decrementAndGet();
            tipo = 1;
            return "° Veiculo(Prioritario)";
        }
    }
    
    public static int mediaPermanencia(){
        int soma = 0;
        int media = 0;

        for(Future<informacoes> temp: resultados ){
            try {
                soma += temp.get().getTempo();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        media = soma / contador.get();

        return media;
    }

    public static int minPermanencia(){
        int min = 6000;
        int tempo = 0;
        for(Future<informacoes> temp: resultados){
            try {
                tempo = temp.get().getTempo();
                if(tempo < min){
                    min = tempo;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return min;
    }

    public static int maiorPermanencia(){
        int maior = 0;
        int tempo = 0;
        for(Future<informacoes> temp: resultados){
            try {
                tempo = temp.get().getTempo();
                if(tempo > maior){
                    maior = tempo;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return maior;
    }

    public static int somaEntrada(){
        int soma = 0;

        for(Future<informacoes> temp: resultados ){
            try {
                soma += temp.get().getEntrada();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return soma;
    }

    

    public static void estasticasFinais(){
        System.out.println();
        System.out.println("================ ESTATÍSTICAS FINAIS ===================== ");
        System.out.println(" Total de veículos: " + contador.get());
        System.out.println("Conseguiram entrar:" + somaEntrada() );
        System.out.println("Desistiram: " + 0 );
        System.out.println("Taxa de sucesso: " + 00 + "%");
        System.out.println("Tempo médio de permanência:" +  mediaPermanencia() + " ms" );
        System.out.println("Tempo mínimo: " + minPermanencia() + " ms" );
        System.out.println("Tempo máximo: " + maiorPermanencia()  + " ms");
        System.out.println("Taxa de ocupação:" + 00 +  "% ");
        System.out.println("================================================ ");
        System.out.println();
        System.out.println("=========== Simulação Concluída ================ ");


    }
    

    public static void status(){
        System.out.println();
        System.out.println("=============== STATUS DO ESTACIONAMENTO ==================");
        System.out.println("Vagas regulares disponíveis:" + 5 + "/" + normal.availablePermits());
        System.out.println("Vagas prioritárias disponíveis:" + 2 +"/" + prioridade.availablePermits() );
        System.out.println("Total de entradas:" + somaEntrada());
        System.out.println("Total de desistências:" +  00 );
        System.out.println("========================================================== ");
        System.out.println();

    }
}