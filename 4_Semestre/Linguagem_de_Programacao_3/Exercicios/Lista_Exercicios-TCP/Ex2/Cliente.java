import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Cliente {
    public static void main(String[] args) {
        try {
            FileInputStream arquivo = new FileInputStream("names.txt");
            Socket cliente = new Socket("localhost", 1234);
            ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());

            byte[] buffer = new byte[4096];
            int bytesLidos;
            while ((bytesLidos = arquivo.read(buffer)) != -1) {
              saida.write(buffer, 0, bytesLidos);
            }
            
            JOptionPane.showMessageDialog(null, "Arquivo enviado!");
            arquivo.close();
            saida.close();
            cliente.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        

    }
}
