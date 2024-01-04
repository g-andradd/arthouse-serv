package br.com.arthouseserv.repositories;

import br.com.arthouseserv.models.CorProdutoProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorProdutoProdutoRepository extends JpaRepository<CorProdutoProduto,Integer> {
}
