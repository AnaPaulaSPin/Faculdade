import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;

public class Servidor {
    public static void main(String[] var0) {
      String operacoes = "+-/*";
      if (var0.length != 5 || !operacoes.contains(var0[2])) {
         System.out.println("Uso correto: <Operando1> <Operando2> <sinal(+-/*)> <porta> <NomeHost>");
         System.exit(0);
      } 

      try {
               InetAddress var1 = InetAddress.getByName(var0[4]);


               int var2 = Integer.parseInt(var0[3]);
               int op1 = Integer.parseInt(var0[0]);
               int op2 = Integer.parseInt(var0[1]);
               String sinal = var0[2];
               int resultado = 0;

               if(sinal.equals("+") ){
                  resultado = op1 + op2;
               } else if(sinal.equals("-")){
                  resultado = op1 - op2;
               } else if(sinal.equals("*")){
                  resultado = op1 * op2;
               } else if(sinal.equals("/")){
                  resultado = op1 / op2;
               }


               byte[] var3 = ByteBuffer.allocate(4).putInt(resultado).array(); //byte para int
               

               DatagramPacket var4 = new DatagramPacket(var3, var3.length, var1, var2);
               DatagramSocket var5 = new DatagramSocket();
               var5.send(var4);

               System.out.println("Mensagem enviada para " + var1.getHostAddress() + "\nPorta: " + var2 + "\nMensagem: " + resultado);
               var5.close();
            } catch (IOException var6) {
               var6.printStackTrace();
            }
 }
}
