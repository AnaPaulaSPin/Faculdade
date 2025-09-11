
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Cliente {
    public static void main(String[] var0) {
        String operacoes = "+-/*"; 
        Scanner scanner = new Scanner(System.in);
        String[] operacao = new String[3];

        while(true){

            // Primeiro Operando:
            System.out.print("Digite a 1 operação: ");
            operacao[0] = scanner.nextLine();

            // Sinal para a operação:
            System.out.print("Digite o sinal(+-/*): ");
            operacao[1] = scanner.nextLine();

            if(!operacoes.contains(operacao[1])){
                System.out.print("Insira umas dessas operações:+-/*");
                continue;
            }

            //Segundo Operando:
            System.out.print("Digite a 2 operação: ");
            operacao[2] = scanner.nextLine();

            break;
        }

        try {
            DatagramSocket socket = new DatagramSocket();

            //Endereço do servidor:
            InetAddress servidorName = InetAddress.getByName("localhost");
            int servidorPorta = 1234;

            // Organizando a operação:
            String UmOperacao = String.join(";", operacao);
            byte[] OperacaoByte = UmOperacao.getBytes();


            // Preprarando o pacote e enviando:
            DatagramPacket operacaoPacote = new DatagramPacket(OperacaoByte, OperacaoByte.length, servidorName,servidorPorta);
            socket.send(operacaoPacote);

            // Resposta da operação:
            byte[] respostaByte = new byte[4];
            DatagramPacket pkg = new DatagramPacket(respostaByte,respostaByte.length);
            socket.receive(pkg); //Fica bloqueado, esperando o pacote com a mensagem.

            int resultado = ByteBuffer.wrap(pkg.getData()).getInt();

            System.out.println("\nMensagem: " + resultado);

            JOptionPane.showMessageDialog(null,"Resultado: "+ resultado, "Mensagem recebida",1);
            
            socket.close();

        } catch(IOException ioe){

        }
  }
}
