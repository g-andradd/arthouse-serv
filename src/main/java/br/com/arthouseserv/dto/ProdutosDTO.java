package br.com.arthouseserv.dto;


public class ProdutosDTO {
    private Integer idProduto;
    private byte[] contProduto;


    public ProdutosDTO(byte[] contProduto, Integer idProduto) {
        this.contProduto = contProduto;
        this.idProduto = idProduto;
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
}
