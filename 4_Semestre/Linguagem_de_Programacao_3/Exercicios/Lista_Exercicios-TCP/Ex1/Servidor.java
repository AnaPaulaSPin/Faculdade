import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(1234);
            while(true){
                Socket cliente = servidor.accept();
                ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
                saida.flush();
                saida.writeObject("Olaaaa, vc foi conectado aoo servidor 1234 com sucesso!");

                saida.close();
                cliente.close();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
