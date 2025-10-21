import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SistemaLance implements Runnable{
    Lance lanceAtual;
    Socket user;
    List<PrintWriter> clients;
    AtomicInteger vencedor;
    Socket comuniSocket;

    public SistemaLance(Lance lanceAtual, Socket user, List<PrintWriter> clients, AtomicInteger vencedor,Socket comuniSocket){
        this.lanceAtual = lanceAtual;
        this.user = user;
        this.clients = clients;
        this.vencedor = vencedor;
        this.comuniSocket = comuniSocket;

    }
    @Override
    public void run(){
        try {
                   PrintWriter enviarUser = new PrintWriter(comuniSocket.getOutputStream(), true);
                   ObjectOutputStream enviarObjeto = new ObjectOutputStream(user.getOutputStream());
                   enviarObjeto.flush();
                   ObjectInputStream receberUser = new ObjectInputStream(user.getInputStream());
                   
                    
                    clients.add(enviarUser);
                    String nome = (String) receberUser.readObject();
                    broadcast(nome + " entrou no leilao");

                    user.setSoTimeout(25000);
                    while(true){
                        enviarObjeto.writeObject(lanceAtual);
                        try {
                        Lance lanceProx =(Lance) receberUser.readObject();
                        if(lanceAtual.getValor() < lanceProx.getValor()){
                           lanceAtual.setNome(lanceProx.getNome());
                           lanceAtual.setValor(lanceProx.getValor());
                         } 
                        continue;
                    } catch (SocketTimeoutException e) {
                        vencedor.set(lanceAtual.getValor());
                        lanceAtual.setSinal(1);
                        broadcast("Temos um vencedor!! Lance numero: " + vencedor + " do cliente: " + lanceAtual.getNome());
                        
                        break;
                    }
                  }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void broadcast(String msg){
        for(PrintWriter user: clients){
            user.println(msg);
        }

    }
    public void broadcastExeceto(String msg, PrintWriter userAtual){
        for(PrintWriter user: clients){
            if(user != userAtual){
                user.println(msg);
            }
        }
    }
}
