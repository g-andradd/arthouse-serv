package br.com.arthouseserv.repositories;

import br.com.arthouseserv.dto.ProdutosDTO;
import br.com.arthouseserv.models.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    @Query("SELECT ProdutosDTO(p.contProduto,p.idProduto) " +
            "FROM Produto p " +
            "LEFT JOIN CorProdutoProduto cpp " +
            "ON p.idProduto = cpp.produto.idProduto " +
            "LEFT JOIN cpp.coresProduto cp " +
            "LEFT JOIN CaracteristicaProdutoProduto crcpp " +
            "ON crcpp.produto.idProduto = p.idProduto " +
            "LEFT JOIN crcpp.caracteristicasProduto crcp " +
            "WHERE(:cores IS NULL OR cp.nomeCorProduto IN :cores) " +
            "AND(:caracteristicas IS NULL OR crcp.nomeCaracterisiticasProduto IN :caracteristicas)" )
    Page<ProdutosDTO> getProdutosFiltro(List<String> cores, List<String> caracteristicas, Pageable pageable);

}
