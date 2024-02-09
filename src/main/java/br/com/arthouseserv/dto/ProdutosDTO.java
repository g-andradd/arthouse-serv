package br.com.arthouseserv.dto;


public class ProdutosDTO {
    private Integer idProduto;
    private byte[] contProduto;
    private String statusProduto;
    private String nomeProduto;
    private String descProduto;


    public ProdutosDTO(Integer idProduto, byte[] contProduto, String statusProduto, String nomeProduto, String descProduto) {
        this.idProduto = idProduto;
        this.contProduto = contProduto;
        this.statusProduto = statusProduto;
        this.nomeProduto = nomeProduto;
        this.descProduto = descProduto;
    }

    public ProdutosDTO() {
    }

    public byte[] getContProduto() {
        return contProduto;
    }

    public void setContProduto(byte[] contProduto) {
        this.contProduto = contProduto;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getStatusProduto() {
        return statusProduto;
    }

    public void setStatusProduto(String statusProduto) {
        this.statusProduto = statusProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescProduto() {
        return descProduto;
    }

    public void setDescProduto(String descProduto) {
        this.descProduto = descProduto;
    }
}
