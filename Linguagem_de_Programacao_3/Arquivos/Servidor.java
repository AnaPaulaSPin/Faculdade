import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
   public static void main(String[] args){
        try {
            ServerSocket servidor = new ServerSocket(1234);
            System.out.println("Servidor ouvindo a porta 1234...");
            while (true) { 
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());

                 // Recebe bytes do cliente
                 InputStream in = cliente.getInputStream();

                // Cria arquivo para salvar
                FileOutputStream arquivoSaida = new FileOutputStream("arquivo_recebido.txt");
                
                byte[] buffer = new byte[4096];
                int bytesLidos;
                
                // Lê bytes até o fim do stream
                while ((bytesLidos = in.read(buffer)) != -1) {
                arquivoSaida.write(buffer, 0, bytesLidos);
                 }
                
                System.out.println("Arquivo recebido com sucesso!");
                
                arquivoSaida.close();
                cliente.close();
            }
        } catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
        } 
         finally{ 

         }

        }
}
