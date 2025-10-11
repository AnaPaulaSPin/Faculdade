import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor{
    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(1234);
            Socket cliente = servidor.accept();
            InputStream entrada = cliente.getInputStream();

            FileOutputStream arquivoRecebido = new FileOutputStream("arquivo_recebido.txt");

            byte[] buffer = new byte[4096];
            int bytesLidos;
            while ((bytesLidos = entrada.read(buffer)) != -1) {
               arquivoRecebido.write(buffer, 0, bytesLidos);
            }

            arquivoRecebido.close();
            entrada.close();
            servidor.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}