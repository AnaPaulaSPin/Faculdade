import java.util.ArrayList;
import java.util.List;

public class Snapshot {
    private List<Item> itensCapturados;

    public Snapshot(List<Item> itens) {
        this.itensCapturados = new ArrayList<>(itens);
    }

    public List<Item> getItensCapturados() {
        return new ArrayList<>(itensCapturados);
    }
}