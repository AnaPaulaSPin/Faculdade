import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.*;

public class lista {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Callable<Integer> calculo1 = () -> { return 4*5;};
        Callable<Integer> calculo2 = () -> { return 4+5;};
        Callable<Integer> calculo3 = () -> { return 4-5;};
        Callable<Integer> calculo4 = () -> { return 9-5;};
        Callable<Integer> calculo5 = () -> { return 10-5;};

        ArrayList<Callable<Integer>> tarefas = new ArrayList<>();

        tarefas.add(calculo1);
        tarefas.add(calculo2);
        tarefas.add(calculo3);
        tarefas.add(calculo4);
        tarefas.add(calculo5);
      try {
        List<Future<Integer>> resultados = executor.invokeAll(tarefas);
        int soma = 0;
        for(int i = 0; i < 5; i++){
            soma += get(resultados.get(i));

        }
        System.out.println(soma);
        
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }

      executor.shutdown();


    }

    public static int get (Future<Integer> conteudo){
        int resultado = 0;
        try {
            resultado = conteudo.get();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }
}
