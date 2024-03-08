package br.com.arthouseserv.dto;

import java.util.List;

public record ResponseProdutoDTO(TipoProdutoDTO tipoProdutoDTO,
                                 List<CaracteristicaProdutoDTO> caracteristicasProdutoDTO,
                                 List<CorProdutoDTO> coresProdutoDTO, Integer statusProduto, String descricao) {
}
