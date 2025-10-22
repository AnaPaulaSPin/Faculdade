import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

public class SistemaEleicao implements Runnable{
    public Socket eleitor;
    public AtomicInteger candidato1;
    public AtomicInteger candidato2;
    public AtomicInteger candidato3;
    public AtomicInteger candidato4;
    public Opcoes candidatos;

    public SistemaEleicao(Socket elitor, AtomicInteger canditato1, AtomicInteger canditato2, AtomicInteger canditato3, AtomicInteger canditato4, Opcoes candidatos){
        this.candidato1 = canditato1;
        this.candidato2 = canditato2;
        this.candidato3 = canditato3;
        this.candidato4 = canditato4;
        this.eleitor = elitor;
        this.candidatos = candidatos;
    }

    public void run(){
           try {
             ObjectOutputStream enviar = new ObjectOutputStream(eleitor.getOutputStream());
             enviar.flush();
             ObjectInputStream receber = new ObjectInputStream(eleitor.getInputStream());

             enviar.writeObject(candidatos);

             String resultado = (String) receber.readObject();

             if(resultado.equals(candidatos.getOpcao1())){
               candidato1.incrementAndGet();

             } else if(resultado.equals(candidatos.getOpcao2())){
              candidato2.incrementAndGet();

             } else if(resultado.equals(candidatos.getOpcao3())){
              candidato3.incrementAndGet();

             } else{
                candidato4.incrementAndGet();
             }
             resultado = "Resultados\n" + "Candidato: " + candidatos.getOpcao1() + " " + candidato1.get()+ " votos" + "\nCandidato: " + candidatos.getOpcao2() + " " + candidato2.get()+ " votos" + "\nCandidato: " + candidatos.getOpcao3() + " " + candidato3.get()+ " votos" + "\nCandidato: " + candidatos.getOpcao4() + " " + candidato4.get()+ " votos";

             enviar.writeObject(resultado);

           } catch (Exception e) {
              e.printStackTrace();
           }

    }
}
