package br.com.arthouseserv.arthouseserv.models;

import jakarta.persistence.*;

@Entity
@Table(name = "caracteristica_produto_produto")
public class CaracteristicaProdutoProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CARACTERISTICA_PRODUTO_PRODUTO")
    private Integer idCaracteristicasProdutoProduto;

    @ManyToOne
    @JoinColumn(name = "ID_CARACTERISTICAS_PRODUTO")

    private CaracteristicasProduto caracteristicasProduto;
    @ManyToOne
    @JoinColumn(name = "ID_PRODUTO")
    private Produto produto;

    public CaracteristicaProdutoProduto(Integer idCaracteristicasProdutoProduto, CaracteristicasProduto caracteristicasProduto, Produto produto) {
        this.idCaracteristicasProdutoProduto = idCaracteristicasProdutoProduto;
        this.caracteristicasProduto = caracteristicasProduto;
        this.produto = produto;
    }

    public CaracteristicaProdutoProduto() {
    }

    public Integer getIdCaracteristicasProdutoProduto() {
        return idCaracteristicasProdutoProduto;
    }

    public void setIdCaracteristicasProdutoProduto(Integer idCaracteristicasProdutoProduto) {
        this.idCaracteristicasProdutoProduto = idCaracteristicasProdutoProduto;
    }

    public CaracteristicasProduto getCaracteristicasProduto() {
        return caracteristicasProduto;
    }

    public void setCaracteristicasProduto(CaracteristicasProduto caracteristicasProduto) {
        this.caracteristicasProduto = caracteristicasProduto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
