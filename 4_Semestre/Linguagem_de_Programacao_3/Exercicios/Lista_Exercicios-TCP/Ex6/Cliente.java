import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente{
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            Socket eleitor = new Socket("localhost",1234);
            ObjectOutputStream enviar = new ObjectOutputStream(eleitor.getOutputStream());
            enviar.flush();
            ObjectInputStream receber = new ObjectInputStream(eleitor.getInputStream()); 

            Opcoes candidatos = (Opcoes) receber.readObject();
            System.out.println("Escolha uma das opcao abaixo!");

            System.out.println("1- " + candidatos.getOpcao1());
            System.out.println("2- "+ candidatos.getOpcao2());
            System.out.println("3- " +candidatos.getOpcao3());
            System.out.println("4- " + candidatos.getOpcao4());
            String opcao = scan.nextLine();
           while(true){ 

            switch (opcao) {
                case "1":
                    enviar.writeObject(candidatos.getOpcao1());
                    System.out.println("Vc escolheu o candidato: " + candidatos.getOpcao1());
                    break;

                case "2":
                    enviar.writeObject(candidatos.getOpcao2());
                    System.out.println("Vc escolheu o candidato: " + candidatos.getOpcao2());
                    break;
                
                case "3":
                    enviar.writeObject(candidatos.getOpcao3());
                    System.out.println("Vc escolheu o candidato: " + candidatos.getOpcao3());
                    break;

                case "4":
                    enviar.writeObject(candidatos.getOpcao4());
                    System.out.println("Vc escolheu o candidato: " + candidatos.getOpcao4());
                    break;

                default:
                 System.out.println("Opção invalida, tente novamente");
                 continue;

            }
            break;
          }
          String resultados = (String) receber.readObject();
          System.out.println(resultados);
          

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}