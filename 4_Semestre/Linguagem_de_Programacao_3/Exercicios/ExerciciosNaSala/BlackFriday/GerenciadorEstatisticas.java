import java.util.concurrent.atomic.*;

class GerenciadorEstatisticas {
    private final AtomicInteger pedidosGerados = new AtomicInteger(0);
    private final AtomicInteger pedidosProcessados = new AtomicInteger(0);
    private final AtomicInteger pedidosRejeitados = new AtomicInteger(0);
    private final long tempoInicio;
    
    public GerenciadorEstatisticas() {
        this.tempoInicio = System.currentTimeMillis();
    }
    
    public void registrarPedidoGerado() {
        pedidosGerados.incrementAndGet();
    }
    
    public void registrarPedidoProcessado() {
        pedidosProcessados.incrementAndGet();
    }
    
    public void registrarPedidoRejeitado() {
        pedidosRejeitados.incrementAndGet();
    }
    
    public void exibirEstatisticas(int tamanhoFila) {
        // TODO: Implementar exibição formatada
        System.out.println("\n=== ESTATÍSTICAS ===");
        System.out.println("Fila: " + tamanhoFila + " pedidos");
        System.out.println("Gerados: " + pedidosGerados.get());
        System.out.println("Processados: " + pedidosProcessados.get());
        System.out.println("Rejeitados: " + pedidosRejeitados.get());
        System.out.println("===================\n");
    }
    
    public void exibirRelatorioFinal() {
        // TODO: Implementar relatório final completo
        long tempoTotal = System.currentTimeMillis() - tempoInicio;
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║          RELATÓRIO FINAL               ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("╠ Total gerado           :  "+ pedidosGerados.get() + "           ║");
        System.out.println("║Processados com sucesso:  " + pedidosProcessados.get() + "            ║" );
        System.out.println("║ Rejeitados (sem estoque):  " + pedidosRejeitados.get()+ "          ║");
        System.out.println("╠════════════════════════════════════════╣ ");

        float taxasucesso = TaxaSucesso();
        System.out.printf("║ Taxa de sucesso        : %.2f         ║\n", taxasucesso);

        float taxamedia = TaxaMedia(tempoTotal);
        System.out.printf("║ Taxa média:              %.2f          ║\n", taxamedia);
        System.out.println("║ Tempo total execução   : " + tempoTotal+"          ║");
        System.out.println("╠════════════════════════════════════════╣ ");
        if(pedidosRejeitados.get() + pedidosProcessados.get() == pedidosGerados.get() ){
             System.out.println("║ VALIDAÇÃO: Todos os pedidos            ║ \n║    foram processados corretamente!     ║ " );

        }else{
             System.out.println("║ VALIDAÇÃO: Todos os pedidos             ║ \n║    nao conseguiram ser processados corretamente!  ║" );
        }


        System.out.println("╚════════════════════════════════════════╝");
    }

    public float TaxaSucesso(){
        float pedidos = pedidosProcessados.get();
        float pedidosG = pedidosGerados.get();
        float total = (pedidos / pedidosG) * 100;

        return total;
    
    }

    public float TaxaMedia(long tempoTotal){
        float pedidosProcess = pedidosProcessados.get();
        float total = (pedidosProcess / tempoTotal)* 100;
        return total;

    }
}