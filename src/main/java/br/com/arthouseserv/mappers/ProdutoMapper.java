package br.com.arthouseserv.mappers;


import br.com.arthouseserv.models.Produto;
import br.com.arthouseserv.models.StatusProduto;
import br.com.arthouseserv.models.TipoProduto;
import br.com.arthouseserv.models.builders.ProdutoBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.TimeZone;

@Component
public class ProdutoMapper {


    public Produto produtoDTOToEntityAlteracao(TipoProduto tipoProduto, Produto produto, StatusProduto statusProduto) {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT-03:00"));
        return new ProdutoBuilder()
                .setIdProduto(produto.getIdProduto())
                .setDescProduto(produto.getDescProduto())
                .setContProduto(produto.getContProduto())
                .setNomeProduto(produto.getNomeProduto())
                .setTipoProduto(tipoProduto)
                .setStatusProduto(statusProduto)
                .setDataCriacao(produto.getDataCriacao())
                .setIdUsuarioCriacao(produto.getIdUsuarioCriacao())
                .setDataAlteracao(LocalDateTime.now())
                .setIdUsuarioAlteracao(1L)
                .build();
    }

    public Produto produtoDTOToEntityOnlyCont(MultipartFile multipartFile) throws IOException {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT-03:00"));
        return new ProdutoBuilder()
                .setContProduto(multipartFile.getBytes())
                .setNomeProduto(multipartFile.getOriginalFilename())
                .setDataCriacao(LocalDateTime.now())
                .setIdUsuarioCriacao(1L)
                .build();
    }


}
