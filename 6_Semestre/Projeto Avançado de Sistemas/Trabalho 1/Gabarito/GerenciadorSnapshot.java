public class GerenciadorSnapshot {
    private Snapshot snapshot;

    public void salvar(Snapshot snapshot) {
        // TODO: Substitua os itens atuais do carrinho pelos itens armazenados no Snapshot recebido.
        this.snapshot = snapshot;
    }

    public Snapshot obterSnapshot() {
        // TODO: Retorne o Snapshot armazenado.
        return this.snapshot;
    }
}