package br.com.arthouseserv.repositories;

import br.com.arthouseserv.dto.FiltroProdutoDTO;
import br.com.arthouseserv.dto.ProdutosDTO;
import br.com.arthouseserv.models.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Integer> {

    Long buscarTotalProdutos(FiltroProdutoDTO filtroProdutoDTO);

    Page<ProdutosDTO> getProdutosFiltro(FiltroProdutoDTO filtroProdutoDTO, Pageable pageable, Long total);



}
