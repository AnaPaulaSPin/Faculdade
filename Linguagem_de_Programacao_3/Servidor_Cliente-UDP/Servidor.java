
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {
    public static void main(String[] args) {
        if(args.length != 3){
            System.out.println("Uso correto: <Nome da maquina> <Porta> <Mensagem>");
            System.exit(0);
        }
    try {
        InetAddress addr = InetAddress.getByName(args[0]);
        int port = Integer.parseInt(args[1]);
        byte[] msg = args[2].getBytes();
        
        //Monta o pacote
        DatagramPacket pkg = new DatagramPacket(msg, msg.length,addr,port);

        // Cria o DatagramaSocket que será responsavel por enviar a mensagem
        DatagramSocket ds = new DatagramSocket();
        //envia a mensagem
        ds.send(pkg);
        System.out.println("Mensagem enviada para " + addr.getHostAddress() + "\n" + "Porta: " + port + "\n" + "Mensagem: " + args[2]);

        //fecha o DatagramSocket
        ds.close();
    } catch(IOException ioe) {
        ioe.printStackTrace();
    }

    }
}
