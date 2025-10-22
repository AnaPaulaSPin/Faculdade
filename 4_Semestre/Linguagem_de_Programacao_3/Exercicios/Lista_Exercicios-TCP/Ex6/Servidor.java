import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Servidor {
    static Scanner scan = new Scanner(System.in);
    static AtomicInteger candidato1 = new AtomicInteger(0);
    static AtomicInteger candidato2 = new AtomicInteger(0);
    static AtomicInteger candidato3 = new AtomicInteger(0);
    static AtomicInteger candidato4 = new AtomicInteger(0);
    static ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1234);
            String opcao1,opcao2,opcao3,opcao4;
            
            System.out.print("Digite o numero o nome dos candidatos: \nCandidato 1°: "); 
            opcao1 = scan.nextLine();

            System.out.print("Candidato 2°: ");
            opcao2 = scan.nextLine();

            System.out.print("Candidato 3°: ");
            opcao3 = scan.nextLine();

            System.out.print("Candidato 4°: ");
            opcao4 = scan.nextLine();

            Opcoes candidatos = new Opcoes(opcao1, opcao2, opcao3, opcao4);
            System.out.println(opcao1);
            System.out.println(opcao2);
            System.out.println(opcao3);
            System.out.println(opcao4);
            
            
            while (true) {
                Socket cliente = server.accept();
                executor.submit(new SistemaEleicao(cliente, candidato4, candidato3, candidato2, candidato1, candidatos));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}