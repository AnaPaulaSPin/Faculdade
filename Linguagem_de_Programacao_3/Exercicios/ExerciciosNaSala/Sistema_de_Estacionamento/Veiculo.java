import java.util.Random;
import java.util.concurrent.Semaphore;

public class Veiculo {
    private int tipo;
    private String nome;
    Semaphore entrada; 
    Semaphore saida; 
    Semaphore prioridade; 
    Semaphore normal;
    

    public Veiculo(int tipo, String nome,Semaphore entrada,Semaphore saida, Semaphore prioridade, Semaphore normal){
        this.tipo = tipo;
        this.nome = nome;
        this.prioridade = prioridade;
        this.normal = normal;
        this.saida = saida;
        this.entrada = entrada;

    }

    public void estacionar(int tempo){
        try {
            Thread.sleep(tempo);
            System.out.println( this.getNome() + " está saindo do estacionamento... ");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void entrar(){
        try {
            entrada.acquire();
            System.out.println( this.getNome() + "  chegou ao portão de entrada ");
            this.vaga();
            Random random = new Random();
            int tempo = random.nextInt(5000);
            System.out.println( this.getNome() + " está estacionado por " + tempo);
            entrada.release();

            this.estacionar(tempo);
            this.sair();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void sair(){
        try {
            saida.acquire();
            System.out.println( this.getNome() + " está saindo do estacionamento...");
            saida.release();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void vaga(){
        if(this.getTipo() == 1){
            try {
                prioridade.acquire();
                System.out.println(this.getNome() + " conseguiu vaga PRIORITÁRIA");
                prioridade.release();

            } catch (Exception e) {
                e.printStackTrace();
            }
         } else{
            try {
                normal.acquire();
                System.out.println(this.getNome() + " conseguiu vaga NORMAL");

                normal.release();
            } catch (Exception e) {
                e.printStackTrace();
            }

         }

    }

    public Runnable tarefa = () -> {
        this.entrar();
    };

    public int getTipo(){
        return this.tipo;
    }

    public void setTipo(int tipo){
        this.tipo = tipo;
    }

    public String getNome(){
        return this.nome;

    }

    public void setNome(String nome){
        this.nome = nome;
    }
}
