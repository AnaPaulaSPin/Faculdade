import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;

public class Servidor {
    public static void main(String[] var0) {

      while (true) { 
          try {
               // criar um ponto de conexão:
               DatagramSocket socket = new DatagramSocket(1234);
               // buffer que vai receber os dados
               byte[] buffer = new byte[256];
               //pacote com o buffer:
               DatagramPacket PkgOperacao = new DatagramPacket(buffer,buffer.length);
               socket.receive(PkgOperacao); // fica em estado de bloqueando esperando um pacote chegar.

               //pedido chegou!
               String operacao = new String(PkgOperacao.getData()).trim();
               String[] listOperacao = operacao.split(";"); //Separar em um array as operações


               //Separando e Atribuindo para cada integrante da operação:
               // String para byte
               int op1 = Integer.parseInt(listOperacao[0]); 
               int op2 = Integer.parseInt(listOperacao[2]);
               String sinal = listOperacao[1];
               int resultado = 0;

               InetAddress ClienteAddr = PkgOperacao.getAddress();
               int ClientePorta =  PkgOperacao.getPort();

               //Identificar a operação e resolver:
               if(sinal.equals("+") ){
                  resultado = op1 + op2;
               } else if(sinal.equals("-")){
                  resultado = op1 - op2;
               } else if(sinal.equals("*")){
                  resultado = op1 * op2;
               } else if(sinal.equals("/")){
                  
                  if(op2 == 0){
                     System.err.println("Nao foi possivel fazer a divisão, o segundo operando é igual a 0!");
                  } else{
                     resultado = op1 / op2;
                  }
               }

               byte[] resultadoByte = ByteBuffer.allocate(4).putInt(resultado).array(); //int para byte

               DatagramPacket pacoteResultado = new DatagramPacket(resultadoByte, resultadoByte.length, ClienteAddr, ClientePorta);
               
               socket.send(pacoteResultado);

               System.out.println("Mensagem enviada");
               socket.close();
            } catch (IOException var6) {
               var6.printStackTrace();
            }
      }
   }
 }

