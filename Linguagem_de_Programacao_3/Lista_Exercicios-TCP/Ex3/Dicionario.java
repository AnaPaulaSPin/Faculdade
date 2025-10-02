import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class Dicionario {
     public static void main(String[] args) {
         int port = 1234;
         try {
            InetAddress adr = InetAddress.getByName("localhost");
            ServerSocket dicionario = new ServerSocket(port);
            int i = 0;

            

            while(true){
                System.out.println("Esperando receber palavras...");
                Socket cliente = dicionario.accept();

                ObjectOutputStream saida = new ObjectOutputStream((cliente.getOutputStream()));
                ObjectInputStream entrada = new ObjectInputStream((cliente.getInputStream()));

                byte[] palavraByte = (byte[]) entrada.readObject();
                String palavraString = new String(palavraByte).trim();

                String significado = BuscarDicionario(palavraString);
                byte[] b = significado.getBytes();



                saida.writeObject(b);
                saida.flush();

                if(i == 2){
                    saida.close();
                    entrada.close();
                    cliente.close();
                }

                

            }

             
         } catch (Exception e) {
            e.printStackTrace();
         }
     }

     public static String BuscarDicionario(String palavra) {
        if (palavra.equalsIgnoreCase("cachorro")) {
            return "Animal doméstico que late.";
        } else if (palavra.equalsIgnoreCase("gato")) {
            return "Animal doméstico que mia.";
        } else if (palavra.equalsIgnoreCase("java")) {
            return "Linguagem de programação orientada a objetos.";
        } else if (palavra.equalsIgnoreCase("python")) {
            return "Linguagem de programação muito usada em IA e ciência de dados.";
        } else if (palavra.equalsIgnoreCase("rede")) {
            return "Conjunto de computadores interconectados.";
        } else if (palavra.equalsIgnoreCase("computador")) {
            return "Máquina capaz de processar informações.";
        } else {
            return "Palavra não encontrada no dicionário.";
        }
    }
}
