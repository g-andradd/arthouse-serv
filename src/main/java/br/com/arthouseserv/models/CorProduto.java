package br.com.arthouseserv.models;

import jakarta.persistence.*;

@Entity
@Table(name = "cores_produto")
public class CorProduto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COR_PRODUTO")
    private Integer idCorProduto;
    @Column(name = "NOME_COR_PRODUTO")
    private String nomeCorProduto;

    @Column(name = "DESC_COR_PRODUTO")
    private String descCorProduto;

    public CorProduto(Integer idCorProduto, String nomeCorProduto, String descCorProduto) {
        this.idCorProduto = idCorProduto;
        this.nomeCorProduto = nomeCorProduto;
        this.descCorProduto = descCorProduto;
    }

    public CorProduto() {
    }

    public Integer getIdCorProduto() {
        return idCorProduto;
    }

    public void setIdCorProduto(Integer idCorProduto) {
        this.idCorProduto = idCorProduto;
    }

    public String getNomeCorProduto() {
        return nomeCorProduto;
    }

    public void setNomeCorProduto(String nomeCorProduto) {
        this.nomeCorProduto = nomeCorProduto;
    }

    public String getDescCorProduto() {
        return descCorProduto;
    }

    public void setDescCorProduto(String descCorProduto) {
        this.descCorProduto = descCorProduto;
    }
}
