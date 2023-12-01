package br.com.arthouseserv.repositories;

import br.com.arthouseserv.models.CoresProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoresProdutoRepository extends JpaRepository<CoresProduto,Integer> {


}
