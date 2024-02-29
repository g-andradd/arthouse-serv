package br.com.arthouseserv.dto;

public class ProdutoIdDTO {
    private Integer id;
    private String nomeProduto;
    private String descProduto;
    private byte[] contProduto;


    public ProdutoIdDTO() {
    }

    public ProdutoIdDTO(Integer id,byte[] contProduto, String nomeProduto, String descProduto) {
        this.id = id;
        this.contProduto = contProduto;
        this.nomeProduto = nomeProduto;
        this.descProduto = descProduto;
    }

    public byte[] getContProduto() {
        return contProduto;
    }

    public void setContProduto(byte[] contProduto) {
        this.contProduto = contProduto;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
