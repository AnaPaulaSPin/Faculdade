import java.util.concurrent.*;
import java.util.concurrent.locks.*;

class GerenciadorEstoque {
    private final ConcurrentHashMap<String, Integer> estoque;
    private final ReadWriteLock lock;
    
    public GerenciadorEstoque() { 
        this.estoque = new ConcurrentHashMap<>();
        this.lock = new ReentrantReadWriteLock();
        inicializarEstoque();
    }
    
    private void inicializarEstoque() {
        estoque.put("Notebook", 10);
        estoque.put("Mouse", 50);
        estoque.put("Teclado", 30);
        estoque.put("Monitor", 15);
        estoque.put("Headset", 25);
    }
    
    public int consultarEstoque(String produto) {
        int resulEstoque = 0;
        // TODO: Implementar consulta com read lock

        lock.readLock().lock();
          resulEstoque = estoque.get(produto);
        lock.readLock().unlock();
        return resulEstoque;
    }
    
    public boolean reservarEstoque(String produto, int quantidade) {
        // TODO: Implementar reserva com write lock
        // 1. Adquirir write lock
        // 2. Verificar se tem estoque suficiente
        // 3. Decrementar estoque
        // 4. Liberar lock
        lock.writeLock().lock();
           int resulEstoque = consultarEstoque(produto);
         if( resulEstoque != 0 && resulEstoque >= quantidade){
            estoque.put(produto, (resulEstoque - quantidade) );
            lock.writeLock().unlock();
            return true;
         }
        return false;
    }
    
    public void devolverEstoque(String produto, int quantidade) {
        lock.writeLock().lock();
           int resulEstoque = consultarEstoque(produto);
            estoque.put(produto, (resulEstoque + quantidade) );
        lock.writeLock().unlock();
    }
    
    public void exibirEstoque() {
        lock.readLock().lock();
        try {
            System.out.println("\n=== ESTOQUE ATUAL ===");
            estoque.forEach((produto, qtd) -> 
                System.out.printf("%s: %d unidades\n", produto, qtd));
            System.out.println("====================\n");
        } finally {
            lock.readLock().unlock();
        }
    }
}