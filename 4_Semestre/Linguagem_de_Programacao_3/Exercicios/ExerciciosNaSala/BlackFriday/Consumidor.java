import java.util.Random;
import java.util.concurrent.*;

class Consumidor implements Runnable {
    private final BlockingQueue<Pedido> fila;
    private final GerenciadorEstoque estoque;
    private final GerenciadorEstatisticas stats;
    private static int id;
    private final Random random = new Random();
    
    public Consumidor(int id, BlockingQueue<Pedido> fila, GerenciadorEstoque estoque, GerenciadorEstatisticas stats) {
        this.id = id;
        this.fila = fila;
        this.estoque = estoque; 
        this.stats = stats;
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                
                // TODO: Remover pedido da fila com timeout (poll com 5 segundos)
                // Se null, significa que não há mais pedidos, pode encerrar
               Pedido pedido = fila.poll(5,TimeUnit.SECONDS) ;
                if(pedido == null){
                    System.out.println("[Consumidor-" + id + "] Finalizou processamento");
                    break;
                } else{
                    // TODO: Processar pedido
                    // TODO: Se null, break do loop
                    processarPedido(pedido);
                }
                break;
            }
            
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("[Consumidor-" + id + "] Finalizou processamento");
        }
    }
    
    private void processarPedido(Pedido pedido) throws InterruptedException {
        // TODO: Implementar processamento
        // 1. Verificar estoque
        // 2. Reservar estoque
        // 3. Simular processamento (100-300ms)
        // 4. Atualizar estatísticas
    }
}