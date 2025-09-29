import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SomaTotal {
    static int n = 0;
    static Scanner entrada = new Scanner(System.in);
    static ExecutorService executor = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        Callable<Integer> tarefa = () -> {  
         int soma = 0;
            for(int i = 1; i < n; i++){
               soma = soma + i;
             }
             System.out.println("Nome: " + Thread.currentThread().getName());
            return soma;
            
           };

        while (true) {
          System.out.print("Digite o numero que vc deseja ve a soma acumulativa(Digite -1 para sair): ");
          n = entrada.nextInt();

          if( n < 0){
            System.out.println("Saindo...");
            break;
          }

            Future<Integer> conteudo = executor.submit(tarefa);
            int resultado = get(conteudo);
            System.out.println(resultado);
          
        }
    
        executor.shutdown();

    }

    public static int get (Future<Integer> resultado){
        int conteudo = 0;
        try {
            conteudo = resultado.get();

        } catch (Exception e) {
           System.out.println(e.getMessage()); 
        } 
        return conteudo;

    }
}
