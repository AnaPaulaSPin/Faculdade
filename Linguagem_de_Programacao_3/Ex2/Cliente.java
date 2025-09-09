
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.ByteBuffer;
import javax.swing.JOptionPane;

public class Cliente {
    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("Informe a porta a ser ouvida");
            System.exit(0);
        }
        try {
            int port = Integer.parseInt(args[0]);
            DatagramSocket ds = new DatagramSocket(port);
            byte[] msg = new byte[256];

            DatagramPacket pkg = new DatagramPacket(msg,msg.length);
            ds.receive(pkg);

            int resultado = ByteBuffer.wrap(pkg.getData()).getInt();

            System.out.println("\nMensagem: " + resultado);

            JOptionPane.showMessageDialog(null, resultado, "Mensagem recebida",1);
            
            ds.close();

        } catch(IOException ioe){

        }
  }
}
