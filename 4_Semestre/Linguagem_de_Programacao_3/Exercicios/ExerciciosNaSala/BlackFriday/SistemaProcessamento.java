import java.util.concurrent.*;

public class SistemaProcessamento {
    static CountDownLatch latch = new CountDownLatch(3);
    static ExecutorService principal = Executors.newSingleThreadExecutor();
    
    public static void main(String[] args) throws InterruptedException {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║   SISTEMA DE PROCESSAMENTO DE PEDIDOS  ║");
        System.out.println("╚════════════════════════════════════════╝\n");
         
        // TODO: Criar BlockingQueue (PriorityBlockingQueue com capacidade 50)
        BlockingQueue<Pedido> fila =  new PriorityBlockingQueue<>();
        
        // TODO: Criar GerenciadorEstoque
        GerenciadorEstoque estoque = new GerenciadorEstoque();
        
        // TODO: Criar GerenciadorEstatisticas
        GerenciadorEstatisticas stats = new GerenciadorEstatisticas();
        
        // TODO: Criar e iniciar Monitor
        Monitor monitor = new Monitor(fila, stats);
        principal.submit(monitor);
        
        // TODO: Criar ExecutorService para produtores (3 threads)
        ExecutorService produtores =Executors.newFixedThreadPool(3);
        
        // TODO: Criar 3 produtores (API, Web, Mobile) - cada um gera 20 pedidos
        Produtor api = new Produtor(fila, "API", 20, stats, latch);
        Produtor web = new Produtor(fila, "Web", 20, stats,latch);
        Produtor mobile = new Produtor(fila, "Mobile", 20, stats,latch);

        produtores.submit(api);
        produtores.submit(web);
        produtores.submit(mobile);

        
        // TODO: Criar ExecutorService para consumidores (5 threads)
        ExecutorService consumidores = Executors.newFixedThreadPool(5);


        // TODO: Aguardar produtores finalizarem
        latch.await();

        CountDownLatch latch2 = new CountDownLatch(5);

        // TODO: Criar 5 consumidores
        Consumidor cons1 = new Consumidor(1, fila, estoque, stats, latch2);
        Consumidor cons2 = new Consumidor(2, fila, estoque, stats, latch2);
        Consumidor cons3 = new Consumidor(3, fila, estoque, stats, latch2);
        Consumidor cons4 = new Consumidor(4, fila, estoque, stats, latch2);
        Consumidor cons5 = new Consumidor(5, fila, estoque, stats, latch2);

        consumidores.submit(cons1);
        consumidores.submit(cons2);
        consumidores.submit(cons3);
        consumidores.submit(cons4);
        consumidores.submit(cons5);
         
        // TODO: Aguardar consumidores finalizarem
        latch2.await();
        
        // TODO: Parar monitor
        monitor.parar();
        
        // TODO: Exibir relatório final
        stats.exibirRelatorioFinal();

        
        // TODO: Exibir estoque final
        estoque.exibirEstoque();
        
        System.out.println("\nSistema finalizado com sucesso!");
        consumidores.shutdown();
        produtores.shutdown();
        principal.shutdown();
    }
}