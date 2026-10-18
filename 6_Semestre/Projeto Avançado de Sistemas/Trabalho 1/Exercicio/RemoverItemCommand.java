public class RemoverItemCommand implements Command {
    private Carrinho carrinho;
    private String nomeItem;

    public RemoverItemCommand(Carrinho carrinho, String nomeItem) {
        this.carrinho = carrinho;
        this.nomeItem = nomeItem;
    }

    @Override
    public void executar() {
        carrinho.removerItem(nomeItem);
    }
}