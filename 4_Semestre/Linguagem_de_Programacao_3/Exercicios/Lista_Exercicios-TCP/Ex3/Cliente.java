import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            //criando o socket cliente:
            Socket cliente = new Socket("localhost",1234);

            //recebe as resposta do servidor:
            ObjectOutputStream saida = new ObjectOutputStream((cliente.getOutputStream()));
            ObjectInputStream entrada = new ObjectInputStream((cliente.getInputStream()));
            

            while(true){
             System.out.println("Digite uma palavra para saber o significado ou digite exit para sair: ");
             String palavra = sc.nextLine();
             if(palavra.equals("exit")){
                System.err.println("Encerrando o programa!!!");
                break;
             }

             byte[] b = palavra.getBytes();
            
             saida.writeObject(b);
             saida.flush();



             byte[] significadoByte = (byte[]) entrada.readObject();
             String signifcString = new String(significadoByte).trim();

             System.out.println("Significado da palavra: " + palavra +" "+ signifcString);


                
            }
            entrada.close();
            cliente.close();
            saida.close();


            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
