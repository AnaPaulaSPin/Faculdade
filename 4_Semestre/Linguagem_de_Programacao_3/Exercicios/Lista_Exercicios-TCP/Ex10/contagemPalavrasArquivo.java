import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class contagemPalavrasArquivo{
    static ExecutorService executor = Executors.newCachedThreadPool();
    static List<Future<Integer>> resultados = new ArrayList<>();

    public static void main(String[] args) {
        
        Callable<Integer> tarefa1 = () -> {
         int cont = 0;
         Scanner sc = new Scanner(new File("arquivo1.txt"));

         while (sc.hasNextLine()) {
            String linha = sc.nextLine();

            String[] palavras = linha.split("\\s+"); // divide por espaços
            cont += palavras.length;
         }
         sc.close();
         return cont;

        };

        Callable<Integer> tarefa2 = () -> {
            int cont = 0;
         Scanner sc = new Scanner(new File("arquivo2.txt"));

         while (sc.hasNextLine()) {
            String linha = sc.nextLine();

            String[] palavras = linha.split("\\s+"); // divide por espaços
            cont += palavras.length;
         }
         sc.close();
         return cont;

        };

        Callable<Integer> tarefa3 = () -> {
         int cont = 0;
         Scanner sc = new Scanner(new File("arquivo3.txt"));

         while (sc.hasNextLine()) {
            String linha = sc.nextLine();

            String[] palavras = linha.split("\\s+"); // divide por espaços
            cont += palavras.length;
         }
          sc.close();
          return cont;
        };


        resultados.add(executor.submit(tarefa1));
        resultados.add(executor.submit(tarefa2));
        resultados.add(executor.submit(tarefa3));

        imprimirQuantidade();
        executor.shutdown();
    }

    public static void imprimirQuantidade(){
        int qtd = 0;
        for(Future<Integer> result: resultados){
            try {
                qtd += result.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println(qtd);
    }
}