import java.util.Random;
import java.util.concurrent.*;

class Produtor implements Runnable {
    private final BlockingQueue<Pedido> fila;
    private final String fonte; // API, Web, Mobile
    private final int quantidadePedidos;
    private final GerenciadorEstatisticas stats;
    private final Random random = new Random();
    private final CountDownLatch latch;
     
    private static final String[] CLIENTES = {"João", "Maria", "Pedro", "Ana", "Carlos"};
    private static final String[] PRODUTOS = {"Notebook", "Mouse", "Teclado", "Monitor", "Headset"};
    private static final PrioridadePedido[] PRIORIDADE_PEDIDOS = PrioridadePedido.values();

    
    public Produtor(BlockingQueue<Pedido> fila, String fonte, int quantidadePedidos, 
                    GerenciadorEstatisticas stats,CountDownLatch latch) {
        this.fila = fila;
        this.fonte = fonte;
        this.quantidadePedidos = quantidadePedidos;
        this.stats = stats;
        this.latch = latch;
    }
    
    @Override
    public void run() {
        try {
            for (int i = 0; i < quantidadePedidos; i++) {
                
                 Pedido pedido = gerarPedidoAleatorio();

                // TODO: Adicionar na fila usando put()
                fila.put(pedido);

                // TODO: Registrar nas estatísticas
                stats.registrarPedidoGerado();

                // TODO: Simular delay entre pedidos (50-200ms)
                try {
                    Thread.sleep(random.nextInt(201));
                    System.out.println("[" + fonte + "] gerou: " + pedido.toString());
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            System.out.println("[" + fonte + "] Finalizou geração de pedidos");
            latch.countDown();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    private Pedido gerarPedidoAleatorio() {
        String Cliente = CLIENTES[random.nextInt(CLIENTES.length)];
        String produto = PRODUTOS[random.nextInt (PRODUTOS.length)];
        int quantidade = random.nextInt(5) + 1;
        PrioridadePedido prioridade = PRIORIDADE_PEDIDOS[random.nextInt(PRIORIDADE_PEDIDOS.length)];

        Pedido pedido = new Pedido(Cliente,produto ,quantidade, prioridade );
        return pedido;
    }

    public String getFonte(){
        return this.fonte;

    }
}