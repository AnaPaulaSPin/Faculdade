import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Servidor{
    private static List<PrintWriter> clients = new CopyOnWriteArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static ExecutorService executor = Executors.newCachedThreadPool();
    public static void main(String[] args) {
        try {
            ServerSocket leilao = new ServerSocket(1234);
            int vencedor = 0;
            int lanceAtual = 0;

            while(vencedor != 0 ){
                Socket cliente = leilao.accept();
                 // Instrumentos para enviar ou receber TEXTO
                PrintWriter enviarUser = new PrintWriter(cliente.getOutputStream(), true);
               ObjectOutputStream enviarUserObject = new ObjectOutputStream(cliente.getOutputStream());
               ObjectInputStream receberUser = new ObjectInputStream(cliente.getInputStream());
                
                clients.add(enviarUser);

                int lanceProx = receberUser.readInt();

                if(lanceAtual < lanceProx){
                    lanceAtual = lanceProx;
                }

                broadcast("Da-lhe uma");
                broadcast("Da-lhe duas");
                broadcast("Da-lhe tres");

                vencedor = lanceAtual;

                broadcast("Temos um vencedor!! Lance numero: " + vencedor);

            }
            leilao.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void broadcast(String msg){
        for(PrintWriter user: clients){
            user.print(msg);
        }
    }


    
}