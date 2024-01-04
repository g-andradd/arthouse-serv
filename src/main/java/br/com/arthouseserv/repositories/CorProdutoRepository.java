package br.com.arthouseserv.repositories;

import br.com.arthouseserv.models.CorProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorProdutoRepository extends JpaRepository<CorProduto,Integer> {


}
