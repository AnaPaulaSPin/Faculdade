import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Corrida {
    private static CountDownLatch contador = new CountDownLatch(1);
    private static CountDownLatch esperar = new CountDownLatch(5);
    private static CountDownLatch corridaCont = new CountDownLatch(5);
    private static Scanner entrada = new Scanner(System.in);


        public static void main(String[] args) {
            ExecutorService executor = Executors.newFixedThreadPool(6);



        Runnable corredor = () -> {
            try {
                System.out.println( "Correndor: " + Thread.currentThread().getName() + " Preparado para corrida!");
                esperar.countDown();
                contador.await();


                System.out.println( "Correndor: " + Thread.currentThread().getName() + " Correndooooo");
                corridaCont.countDown();

            } catch (Exception e) {
                e.printStackTrace();
            }

        };

        while(true){
            for(int i =0; i < 5; i++){
                executor.submit(corredor);
            }

            try {
                esperar.await();
            } catch (Exception e) {
                e.printStackTrace();
            }


            System.out.print("Digite 1 para corrida começar! Ou -1 para sair do programa.");
            int comando = entrada.nextInt();

            if(comando != -1){
                contador.countDown();
            } else{
                System.out.println("Saindo do programa....");
                break;
            }

            try {
                corridaCont.await();
                System.out.println("===================================================");
                System.out.println("Os 5 corredores terminaram a corrida com sucesso!!!");
                System.out.println("===================================================\n");

            } catch (Exception e) {
                e.printStackTrace();
            }

            contador = new CountDownLatch(1);
            esperar = new CountDownLatch(5);
            corridaCont = new CountDownLatch(5);

        }

        


    }
}
