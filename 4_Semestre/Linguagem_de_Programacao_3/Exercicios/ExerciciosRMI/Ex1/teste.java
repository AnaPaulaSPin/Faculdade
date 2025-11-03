import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class teste {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int i =0;
        while(i!= 10){
            try {
                Registry registry = LocateRegistry.getRegistry("localhost", 1099);
                ServicoContadorVisitas servico1 = (ServicoContadorVisitas) registry.lookup("ContadorServicos");
                String resposta = servico1.NumeroVisita("nome");
                System.out.println(resposta);
                i++;

        } catch (Exception e) {
            e.printStackTrace();
        }}
    }
}
