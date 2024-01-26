package br.com.arthouseserv.dto;

import java.util.List;

public record FiltroProdutoDTO(List<String> cores, List<String> caracteristicas, Integer ordenacao) {
}
