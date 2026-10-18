import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Carrinho {
    private List<Item> itens;

    public Carrinho() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public void removerItem(String nome) {
        Iterator<Item> iterator = itens.iterator();

        while (iterator.hasNext()) {
            Item item = iterator.next();

            if (item.getNome().equalsIgnoreCase(nome)) {
                iterator.remove();
                return;
            }
        }
    }

    public double getTotal() {
        double total = 0.0;

        for (Item item : itens) {
            total += item.getPreco();
        }

        return total;
    }

    public void mostrarItens() {
        for (Item item : itens) {
            System.out.println(item);
        }
    }

    public Snapshot capturarSnapshot() {
        // TODO: Crie e retorne um Snapshot contendo uma cópia dos itens atuais do carrinho.
        return null;
    }

    public void restaurarEstado(Snapshot snapshot) {
        // TODO: Substitua os itens atuais do carrinho pelos itens armazenados no Snapshot recebido.
    }
}
