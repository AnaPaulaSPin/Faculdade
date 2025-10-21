import java.util.Random;
import java.util.concurrent.*;

class Consumidor implements Runnable {
    private BlockingQueue<Pedido> fila;
    private GerenciadorEstoque estoque;
    private GerenciadorEstatisticas stats;
    private int id;
    private Random random = new Random();
    private CountDownLatch latch;
    
    public Consumidor(int id, BlockingQueue<Pedido> fila, GerenciadorEstoque estoque, GerenciadorEstatisticas stats, CountDownLatch latch) {
        this.id = id;
        this.fila = fila;
        this.estoque = estoque; 
        this.stats = stats;
        this.latch = latch;
    }
    
    @Override
    public void run() {
        try {
            System.out.println("[Consumidor-" + id + "] Pronto para processar pedidos");
            while (true) {
                
                // TODO: Remover pedido da fila com timeout (poll com 5 segundos)
                // Se null, significa que não há mais pedidos, pode encerrar
                Pedido pedido = fila.poll(5,TimeUnit.SECONDS);
                if(pedido == null){
                    System.out.println("[Consumidor-" + id + "] Finalizou processamento");
                    break;
                } else{
                    // TODO: Processar pedido
                    // TODO: Se null, break do loop
                    if(pedido == null){
                        break;
                    }
                    processarPedido(pedido);
                    
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("[Consumidor-" + id + "] Finalizou processamento");
            
        } finally{
            latch.countDown();
        }
    }
    
    private void processarPedido(Pedido pedido) throws InterruptedException {
    System.out.println("[Consumidor-" + id + "] Processando: Pedido#" + pedido.getId() + " [" + pedido.getPrioridade().name()+"] " + pedido.getCliente() + " - " + pedido.getProduto() + " x" + pedido.getQuantidade() + " ("+ pedido.getTimestamp() + ")");

        // TODO: Implementar processamento
        // 1. Verificar estoque
        // 2. Reservar estoque
        // 3. Simular processamento (100-300ms)
        // 4. Atualizar estatísticas

        if(estoque.reservarEstoque(pedido.getProduto(), pedido.getQuantidade())){
            try {
                Thread.sleep(random.nextInt(301));
                stats.registrarPedidoProcessado();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else{
            System.out.println("[Consumidor-" + id + "]  REJEITADO (sem estoque): Pedido#"+ pedido.getId() + "-" + pedido.getProduto() + "x" + pedido.getQuantidade());
            stats.registrarPedidoRejeitado();
        }
    }
}