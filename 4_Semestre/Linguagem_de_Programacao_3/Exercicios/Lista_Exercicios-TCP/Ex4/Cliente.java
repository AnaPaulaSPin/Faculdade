package Ex4;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            Socket cliente = new Socket("localhost",1234);
            Scanner scan = new Scanner(System.in);
            boolean acertou = false;
        
            ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());

            String mensagem = (String) entrada.readObject();
            System.out.println(mensagem);

            while(true){
                System.out.print(" Digite um numero: ");
                int tentativa = scan.nextInt();
                saida.writeObject(tentativa);

                acertou = (boolean) entrada.readObject();
                mensagem = (String) entrada.readObject();
                System.out.println(mensagem);

                if(acertou == true){
                    break;
                } 
            }

            saida.close();
            entrada.close();
            cliente.close();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
