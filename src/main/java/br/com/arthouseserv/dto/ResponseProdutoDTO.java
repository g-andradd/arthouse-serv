package br.com.arthouseserv.dto;

import java.util.List;

public record ResponseProdutoDTO(Integer idProduto,TipoProdutoDTO tipoProdutoDTO,
                                 List<CaracteristicaProdutoDTO> caracteristicasProdutoDTO,
                                 List<CorProdutoDTO> coresProdutoDTO) {
}
