package br.com.arthouseserv.repositories;

import br.com.arthouseserv.dto.FiltroProdutoDTO;
import br.com.arthouseserv.dto.ProdutosDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public class ProdutoRepositoryImpl {

    private final EntityManager manager;

    @Autowired
    public ProdutoRepositoryImpl( EntityManager manager) {
        this.manager = manager;
    }

    public Long buscarTotalProdutos(FiltroProdutoDTO filtroProdutoDTO) {
        try {

            String sql = " " +
                    "SELECT COUNT(*) " +
                    "FROM Produto p " +
                    "LEFT JOIN CoresProdutoProduto cpp " +
                    "ON p.idProduto = cpp.produto.idProduto " +
                    "LEFT JOIN cpp.coresProduto cp " +
                    "LEFT JOIN CaracteristicaProdutoProduto crcpp " +
                    "ON crcpp.produto.idProduto = p.idProduto " +
                    "LEFT JOIN crcpp.caracteristicasProduto crcp " +
                    "WHERE (:cores IS NULL OR cp.nomeCorProduto IN :cores) " +
                    "AND (:caracteristicas IS NULL OR crcp.nomeCaracterisiticasProduto IN :caracteristicas)";


            TypedQuery<Long> query = manager.createQuery(sql, Long.class);
            query.setParameter("cores", filtroProdutoDTO.cores());
            query.setParameter("caracteristicas", filtroProdutoDTO.caracteristicas());
            return query.getSingleResult();
        } finally {
            manager.close();
        }
    }

    public Page<ProdutosDTO> getProdutosFiltro(FiltroProdutoDTO filtroProdutoDTO, Pageable pageable, Long total) {
        try {

            String sql = " " +
                    "SELECT new br.com.arthouseserv.dto.ProdutosDTO(p.contProduto) " +
                    "FROM Produto p " +
                    "LEFT JOIN CoresProdutoProduto cpp " +
                    "ON p.idProduto = cpp.produto.idProduto " +
                    "LEFT JOIN cpp.coresProduto cp " +
                    "LEFT JOIN CaracteristicaProdutoProduto crcpp " +
                    "ON crcpp.produto.idProduto = p.idProduto " +
                    "LEFT JOIN crcpp.caracteristicasProduto crcp " +
                    "WHERE(:cores IS NULL OR cp.nomeCorProduto IN :cores) " +
                    "AND(:caracteristicas IS NULL OR crcp.nomeCaracterisiticasProduto IN :caracteristicas)";


            TypedQuery<ProdutosDTO> query = manager.createQuery(sql, ProdutosDTO.class);
            query.setParameter("cores", filtroProdutoDTO.cores());
            query.setParameter("caracteristicas", filtroProdutoDTO.caracteristicas());
            query.setMaxResults(pageable.getPageSize());
            query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
            return new PageImpl<>(query.getResultList(), pageable, total);
        } finally {
            manager.close();
        }
    }

}
