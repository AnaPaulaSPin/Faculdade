import java.net.Socket;
import java.util.Scanner;

public class Entrada implements Runnable{
    Socket servertexto;

    public Entrada(Socket serverSocket){
        this.servertexto = serverSocket;
    }

    public void run(){
        try {
            Scanner scan = new Scanner(servertexto.getInputStream());
            while(scan.hasNextLine()){
                System.out.println();
                System.out.println(scan.nextLine());
                System.out.println();
            }

        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}