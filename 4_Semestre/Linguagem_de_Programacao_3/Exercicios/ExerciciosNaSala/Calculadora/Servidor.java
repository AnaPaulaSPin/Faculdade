import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.ByteBuffer;

public class Servidor {
    public static void main(String[] args) {

        try {
            DatagramSocket servidor = new DatagramSocket(1234);
            byte[] receberMsg = new byte[256];
            DatagramPacket pacoteRecebido = new DatagramPacket(receberMsg,receberMsg.length);

            servidor.receive(pacoteRecebido);
            int op1 = ByteBuffer.wrap(receberMsg).getInt();
            System.out.println(op1);

            servidor.receive(pacoteRecebido);
            int op2 = ByteBuffer.wrap(receberMsg).getInt();
            System.out.println(op2);

            servidor.receive(pacoteRecebido);
            String sinal = new String(receberMsg).trim();
            System.out.println(sinal);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
