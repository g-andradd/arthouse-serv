package br.com.arthouseserv.models.builders;

import br.com.arthouseserv.models.Produto;
import br.com.arthouseserv.models.StatusProduto;
import br.com.arthouseserv.models.TipoProduto;

import java.time.LocalDateTime;

public class ProdutoBuilder {

    private Integer idProduto;

    private String nomeProduto;
    private String descProduto;
    private byte[] contProduto;
    private TipoProduto tipoProduto;
    private StatusProduto statusProduto;
    private Long idUsuarioCriacao;
    private LocalDateTime dataCriacao;
    private Long idUsuarioAlteracao;
    private LocalDateTime dataAlteracao;

    public ProdutoBuilder setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
        return this;
    }

    public ProdutoBuilder setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
        return this;
    }

    public ProdutoBuilder setDescProduto(String descProduto) {
        this.descProduto = descProduto;
        return this;
    }

    public ProdutoBuilder setContProduto(byte[] contProduto) {
        this.contProduto = contProduto;
        return this;
    }

    public ProdutoBuilder setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
        return this;
    }

    public ProdutoBuilder setIdUsuarioCriacao(Long idUsuarioCriacao) {
        this.idUsuarioCriacao = idUsuarioCriacao;
        return this;

    }

    public ProdutoBuilder setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
        return this;

    }

    public ProdutoBuilder setIdUsuarioAlteracao(Long idUsuarioAlteracao) {
        this.idUsuarioAlteracao = idUsuarioAlteracao;
        return this;

    }

    public ProdutoBuilder setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
        return this;

    }

    public ProdutoBuilder setStatusProduto(StatusProduto statusProduto) {
        this.statusProduto = statusProduto;
        return this;
    }

    public Produto build() {
        Produto produto = new Produto();
        produto.setIdProduto(this.idProduto);
        produto.setNomeProduto(this.nomeProduto);
        produto.setDescProduto(this.descProduto);
        produto.setContProduto(this.contProduto);
        produto.setTipoProduto(this.tipoProduto);
        produto.setStatusProduto(this.statusProduto);
        produto.setIdUsuarioCriacao(this.idUsuarioCriacao);
        produto.setDataCriacao(this.dataCriacao);
        produto.setIdUsuarioAlteracao(this.idUsuarioAlteracao);
        produto.setDataAlteracao(this.dataAlteracao);
        return produto;
    }
}
