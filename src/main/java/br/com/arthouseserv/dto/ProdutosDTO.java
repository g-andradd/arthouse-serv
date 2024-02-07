package br.com.arthouseserv.dto;


public class ProdutosDTO {
    private Integer idProduto;
    private byte[] contProduto;

    private String statusProduto;


    public ProdutosDTO(byte[] contProduto, Integer idProduto,String statusProduto) {
        this.contProduto = contProduto;
        this.idProduto = idProduto;
        this.statusProduto = statusProduto;
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
}
