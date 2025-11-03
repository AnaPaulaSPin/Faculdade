import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente  {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        try {
                Registry registry = LocateRegistry.getRegistry("localhost", 1099);
                ServicoContadorVisitas servico1 = (ServicoContadorVisitas) registry.lookup("ContadorServicos");
                System.out.print("Registre seu nome: ");
                String nome = scan.nextLine();
                String resposta = servico1.NumeroVisita(nome);
                System.out.println(resposta);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
