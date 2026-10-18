public class AdicionarItemCommand implements Command {
    private Carrinho carrinho;
    private Item item;

    public AdicionarItemCommand(Carrinho carrinho, Item item) {
        this.carrinho = carrinho;
        this.item = item;
    }

    @Override
    public void executar() {
        carrinho.adicionarItem(item);
    }
}