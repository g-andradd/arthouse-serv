package br.com.arthouseserv.models;

import jakarta.persistence.*;

@Entity
@Table(name = "STATUS_PRODUTO")
public class StatusProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_STATUS_PRODUTO")
    private Integer idStatusProduto;

    @Column(name = "NOME_STATUS_PRODUTO")
    private String nomeStatusProduto;

    public StatusProduto(Integer idStatusProduto, String nomeStatusProduto) {
        this.idStatusProduto = idStatusProduto;
        this.nomeStatusProduto = nomeStatusProduto;
    }

    public StatusProduto() {
    }

    public Integer getIdStatusProduto() {
        return idStatusProduto;
    }

    public void setIdStatusProduto(Integer idStatusProduto) {
        this.idStatusProduto = idStatusProduto;
    }

    public String getNomeStatusProduto() {
        return nomeStatusProduto;
    }

    public void setNomeStatusProduto(String nomeStatusProduto) {
        this.nomeStatusProduto = nomeStatusProduto;
    }
}
