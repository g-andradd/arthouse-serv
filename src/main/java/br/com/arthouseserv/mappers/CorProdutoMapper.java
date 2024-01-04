package br.com.arthouseserv.mappers;

import br.com.arthouseserv.dto.CorProdutoDTO;
import br.com.arthouseserv.models.CorProduto;
import org.springframework.stereotype.Component;

@Component
public class CorProdutoMapper {

    public CorProdutoDTO toDTO(CorProduto corProduto) {
        return new CorProdutoDTO(
                corProduto.getIdCorProduto(),
                corProduto.getNomeCorProduto()
        );
    }

}
