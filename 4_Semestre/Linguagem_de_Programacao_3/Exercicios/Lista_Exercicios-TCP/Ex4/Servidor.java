package Ex4;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Servidor {
    public static void main(String[] args) {
       try {
         ServerSocket servidor = new ServerSocket(1234);
          Random random = new Random();
         while (true) {
            Socket cliente = servidor.accept();
            ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            int numero = random.nextInt(100);
           
            saida.flush();
            saida.writeObject("Seja bem vindo(a), ao nosso jogo de adivinhação!");
            saida.flush();


            while(true){
              int numeroTentativa = (int) entrada.readObject();

              if(numero == numeroTentativa){
                 saida.writeObject(true);
                 saida.writeObject("Parabens vc acertou!! O numero era " + numero);
                 saida.flush();
                 break;
                 
              } else if(numeroTentativa > numero){
                saida.writeObject(false);
                saida.writeObject("Errado! o numero tem que ser menor!" );
                saida.flush();

              } else{
                saida.writeObject(false);
                saida.writeObject("Errado! o numero tem que ser maior!");
                saida.flush();
              }
            }
            saida.close();
            entrada.close();
            cliente.close();
         }

       } catch (Exception e) {
          e.printStackTrace();
       }

    }
}
