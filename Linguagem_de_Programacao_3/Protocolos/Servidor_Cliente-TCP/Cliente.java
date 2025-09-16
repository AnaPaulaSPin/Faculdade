import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Date;

import javax.swing.JOptionPane;

public class Cliente {
    public static void main(String[] args) {
        try {
            System.out.println("Tentando conectar ao servidor...");
            Socket cliente = new Socket("127.0.0.1", 1234);
            System.out.println("Conectado ao servidor!");

            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            System.out.println("Recebendo data do servidor...");
            Date data_atual = (Date) entrada.readObject();
            JOptionPane.showMessageDialog(null, "Data recebida do servidor: " + data_atual.toString());

            entrada.close();
            cliente.close();
            System.out.println("Conexão encerrada");
        } catch (Exception e) {
            System.out.println("Erro no cliente:");
            e.printStackTrace();
        }
    }
}
