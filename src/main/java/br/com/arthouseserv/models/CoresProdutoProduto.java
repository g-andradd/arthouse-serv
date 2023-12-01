package br.com.arthouseserv.models;

import jakarta.persistence.*;

@Entity
@Table(name = "cores_produto_produto")
public class CoresProdutoProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CORES_PRODUTO_PRODUTO")
    private Integer idCoresProdutoProduto;

    @ManyToOne
    @JoinColumn(name = "ID_COR_PRODUTO")
    private CoresProduto coresProduto;

    @ManyToOne
    @JoinColumn(name = "ID_PRODUTO")
    private Produto produto;

    public CoresProdutoProduto(CoresProduto coresProduto, Produto produto) {
        this.coresProduto = coresProduto;
        this.produto = produto;
    }

    public CoresProdutoProduto() {
    }

    public Integer getIdCoresProdutoProduto() {
        return idCoresProdutoProduto;
    }

    public void setIdCoresProdutoProduto(Integer idCoresProdutoProduto) {
        this.idCoresProdutoProduto = idCoresProdutoProduto;
    }

    public CoresProduto getCoresProduto() {
        return coresProduto;
    }

    public void setCoresProduto(CoresProduto coresProduto) {
        this.coresProduto = coresProduto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
