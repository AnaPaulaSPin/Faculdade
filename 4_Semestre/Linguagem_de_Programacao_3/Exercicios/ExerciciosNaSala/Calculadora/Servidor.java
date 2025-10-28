import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.ByteBuffer;

public class Servidor {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        int validacao = 0; 

        try {
            DatagramSocket servidor = new DatagramSocket(1234);
            byte[] receberMsg = new byte[1024];
            DatagramPacket pacoteRecebido = new DatagramPacket(receberMsg,receberMsg.length);

            //Receber op1
            servidor.receive(pacoteRecebido);
            int op1 = ByteBuffer.wrap(receberMsg).getInt();

            // Receber o op2
            servidor.receive(pacoteRecebido);
            int op2 = ByteBuffer.wrap(receberMsg).getInt();
            calculadora.setOp2(op2);

            // Receber e validar a conta
            servidor.receive(pacoteRecebido);
            String sinal = new String(receberMsg,0,pacoteRecebido.getLength()).trim();
            System.out.println(sinal);

            if(calculadora.verificarSinal(sinal)){
                calculadora.setSinal(sinal);
                validacao = 1;
                 //Fazer o calculo
                  float resposta = calculadora.operacao();
                  byte[] enviarMsg =  ByteBuffer.allocate(8).putDouble(resposta).array();
                  DatagramPacket pacote = new DatagramPacket(enviarMsg, enviarMsg.length,pacoteRecebido.getAddress(),pacoteRecebido.getPort());
                  servidor.send(pacote);

            }
            
            // Enviar validacao do sinal
            byte[] enviarMsg =  ByteBuffer.allocate(4).putInt(validacao).array();
            DatagramPacket pacote = new DatagramPacket(enviarMsg, enviarMsg.length,pacoteRecebido.getAddress(),pacoteRecebido.getPort());
            servidor.send(pacote);

           
            



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
