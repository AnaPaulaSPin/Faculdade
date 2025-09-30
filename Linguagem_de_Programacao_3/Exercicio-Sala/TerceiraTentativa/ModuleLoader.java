import java.util.concurrent.CountDownLatch;

class ModuleLoader implements Runnable{
    private String nomeMetodo;
    private int segundos;
    private CountDownLatch latch;

    public ModuleLoader(String nome, int segundos, CountDownLatch latch) {
        this.nomeMetodo = nome;
        this.segundos = segundos;
        this.latch = latch;
    }
    @Override
    public void run(){
        try {
            System.out.println("[CARREGANDO] Módulo de " + this.getNomeMetodo() + " iniciando...\r\n");
            Thread.sleep(this.getSegundos());

            System.out.println("[OK] Módulo de " + this.getNomeMetodo() + " carregado.\r");
            latch.countDown();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public String getNomeMetodo(){
        return this.nomeMetodo;
    }

    public int getSegundos(){
        return this.segundos;
    }
}
    

