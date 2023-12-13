package br.com.arthouseserv.models;

import jakarta.persistence.*;

@Entity
@Table(name = "caracteristicas_produto")
public class CaracteristicasProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CARACTERISTICAS_PRODUTO")
    private Integer idCaracteristicasProduto;
    @Column(name = "NOME_CARACTERISTICAS_PRODUTO")
    private String nomeCaracterisiticasProduto;

    @Column(name = "IMG_CARACTERISTICAS_PRODUTO")
    private byte[] imgCaracterisiticasProduto;

    public CaracteristicasProduto(Integer idCaracteristicasProduto, String nomeCaracterisiticasProduto, byte[] imgCaracterisiticasProduto) {
        this.idCaracteristicasProduto = idCaracteristicasProduto;
        this.nomeCaracterisiticasProduto = nomeCaracterisiticasProduto;
        this.imgCaracterisiticasProduto = imgCaracterisiticasProduto;
    }

    public CaracteristicasProduto() {
    }

    public Integer getIdCaracteristicasProduto() {
        return idCaracteristicasProduto;
    }

    public void setIdCaracteristicasProduto(Integer idCaracteristicasProduto) {
        this.idCaracteristicasProduto = idCaracteristicasProduto;
    }

    public String getNomeCaracterisiticasProduto() {
        return nomeCaracterisiticasProduto;
    }

    public void setNomeCaracterisiticasProduto(String nomeCaracterisiticasProduto) {
        this.nomeCaracterisiticasProduto = nomeCaracterisiticasProduto;
    }

    public byte[] getImgCaracterisiticasProduto() {
        return imgCaracterisiticasProduto;
    }

    public void setImgCaracterisiticasProduto(byte[] imgCaracterisiticasProduto) {
        this.imgCaracterisiticasProduto = imgCaracterisiticasProduto;
    }
}
