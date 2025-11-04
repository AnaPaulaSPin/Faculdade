import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class Cliente {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            System.out.print("Bem vindo ao Registrador de Mensagem! Onde a mensagem que vc gravar aqui todos poderam ve e ficar marcado para sempre!\nDigite seu nome: ");
            String nome = scan.nextLine();
    
            System.out.println("Digite a mensagem que vc gostaria de deixar registrada: ");
            String mensagem = scan.nextLine();
    
            Registry registro = LocateRegistry.getRegistry("localhost",1099);

            ServidorMensagem server = (ServidorMensagem) registro.lookup("mandarMensagens");

            List<String> mensagens = server.addMensagem(nome, mensagem);

            for(String msg: mensagens){
                System.out.println(msg);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
