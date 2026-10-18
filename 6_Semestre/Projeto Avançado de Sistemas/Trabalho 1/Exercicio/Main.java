public class Main {
    public static void main(String[] args) {

        Carrinho carrinho = new Carrinho();
        GerenciadorSnapshot gerenciador = new GerenciadorSnapshot();

        Item livro = new Item("Livro", 50.00);
        Item caderno = new Item("Caderno", 25.00);
        Item caneta = new Item("Caneta", 5.00);

        // Adicionando itens por meio de comandos
        Command adicionarLivro =
                new AdicionarItemCommand(carrinho, livro);

        Command adicionarCaderno =
                new AdicionarItemCommand(carrinho, caderno);

        adicionarLivro.executar();
        adicionarCaderno.executar();

        System.out.println("=== Estado inicial ===");
        carrinho.mostrarItens();

        // Capturando e armazenando o estado
        Snapshot snapshot = carrinho.capturarSnapshot();
        gerenciador.salvar(snapshot);

        // Modificando o carrinho após a captura
        Command removerLivro =
                new RemoverItemCommand(carrinho, "Livro");

        Command adicionarCaneta =
                new AdicionarItemCommand(carrinho, caneta);

        removerLivro.executar();
        adicionarCaneta.executar();

        System.out.println("\n=== Após as modificações ===");
        carrinho.mostrarItens();

        // Recuperando o estado salvo pelo Caretaker
        Snapshot snapshotSalvo = gerenciador.obterSnapshot();
        carrinho.restaurarEstado(snapshotSalvo);

        System.out.println("\n=== Após restaurar o estado ===");
        carrinho.mostrarItens();
    }
}