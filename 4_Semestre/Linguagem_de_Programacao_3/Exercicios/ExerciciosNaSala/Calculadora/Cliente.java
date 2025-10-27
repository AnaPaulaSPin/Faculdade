import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.Scanner;

public class Cliente {
    static Scanner scan = new Scanner(System.in);
    static int op1, op2, sinal;
    static String entrada;

    public static void main(String[] args) {
        try {
            
            DatagramSocket cliente = new DatagramSocket();
            byte[] receberMsg = new byte[256]; 
            InetAddress addr = InetAddress.getByName("localhost");
            int port = 1234;

            //Operando 1:
            while(true){
                System.out.print("Digite o primeiro operador: ");
                entrada = scan.nextLine();
                if(verificaEntrada(entrada)){
                    op1 = converterNumero(entrada);
                    break;
                }
            }
            byte[] enviarMsg = ByteBuffer.allocate(4).putInt(op1).array();
            DatagramPacket pacote = new DatagramPacket(enviarMsg, enviarMsg.length,addr,port);
            cliente.send(pacote);

             //Operando 2:
             while(true){
                System.out.print("Digite o segundo operador: ");
                entrada = scan.nextLine();
                if(verificaEntrada(entrada)){
                    op1 = converterNumero(entrada);
                    break;
                }
            }
            enviarMsg = ByteBuffer.allocate(4).putInt(op1).array();
            pacote = new DatagramPacket(enviarMsg, enviarMsg.length,addr,port);
            cliente.send(pacote);

            //Sinal:
            while(true){
             System.out.print("Digite uma operacao(+,-,*,/,%): ");
             sinal = scan.nextInt();
             enviarMsg = ByteBuffer.allocate(4).putInt(op1).array();
            }
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean verificaEntrada(String op){
        if(op.matches("\\d+")){
            return true;
        } else{
            System.out.println("Digite apenas numeros!");
            return false;
        }
    }

    public static int converterNumero(String numero){
          return Integer.parseInt(entrada);
    }


}
