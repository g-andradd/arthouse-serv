package br.com.arthouseserv.arthouseserv.models;

import jakarta.persistence.*;

@Entity
@Table(name = "cores_produto")
public class CoresProduto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COR_PRODUTO")
    private Integer idCorProduto;
    @Column(name = "NOME_COR_PRODUTO")
    private String nomeCorProduto;

    @Column(name = "DESC_COR_PRODUTO")
    private String descCorProduto;


}
