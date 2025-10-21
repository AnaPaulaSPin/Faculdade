import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Cliente{
    static Scanner scan = new Scanner(System.in);
    static ExecutorService executor = Executors.newFixedThreadPool(1);
    
    public static void main(String[] args) {
        try {
            Socket user = new Socket("localhost",1234);
            Socket comuniSocket = new Socket("localhost", 3454);
            PrintWriter enviarTexto = new PrintWriter(comuniSocket.getOutputStream(), true);
            ObjectOutputStream enviarServer = new ObjectOutputStream(user.getOutputStream());
            enviarServer.flush();
            ObjectInputStream receberServer = new ObjectInputStream(user.getInputStream());
            

            System.out.print("Digite seu nome: ");
            String nome = scan.nextLine();
            Lance lanceUser = new Lance(nome, 0, 0);

            enviarServer.writeObject(nome);
            executor.submit(new Entrada(comuniSocket));
            while(true){
               Lance lanceAtual = (Lance) receberServer.readObject();
               if(lanceAtual.getSinal() == 1){
                 break;
               }
               System.out.print("Gostaria de da um lance?(s/n): ");
               String resposta = scan.nextLine();

               if(resposta.equals("s")){
                System.out.println("Digite seu lance: ");
                if(lanceAtual.sinal != 1){
                    lanceUser.setValor(scan.nextInt());
                    enviarServer.writeObject(lanceUser);
                }
               }
            }
            user.close();
            comuniSocket.close();
            enviarServer.close();
            receberServer.close();
            enviarTexto.close();
            executor.shutdownNow();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
}