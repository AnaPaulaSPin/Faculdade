import java.io.ObjectInputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Cliente {
    public static void main(String[] args) {
       try {
         Socket cliente = new Socket("localhost", 1234);
         ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());

         String mensagem = (String) entrada.readObject();

         JOptionPane.showMessageDialog(null, "Mensagem recebida: " + mensagem);

         cliente.close();
         entrada.close();

       } catch (Exception e) {
         e.printStackTrace();

       }
    }
}