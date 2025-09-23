public class Volatile {
    private static volatile  int numero = 0;
    private static volatile  boolean preparado = false;

    private static class MeuRunnable implements Runnable{
        @Override 
        public void run(){
            while(!preparado){
                Thread.yield();
            }
            System.out.print("Numero: " + numero);
        }
    }

    public static void main(String[] args) {
        Thread t0 = new Thread(new MeuRunnable());
        t0.start();
        numero = 42;
        preparado = true;
    }
}
