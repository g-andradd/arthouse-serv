package br.com.arthouseserv.repositories;

import br.com.arthouseserv.models.CoresProdutoProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoresProdutoProdutoRepository extends JpaRepository<CoresProdutoProduto,Integer> {
}
