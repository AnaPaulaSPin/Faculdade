package aplicacao.com.projeto.api.Modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "carrinho")
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer quantidade;

    // Many Carrinho -> One Cliente
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    // Many Carrinho -> One Produto
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    // Getters e setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
