package br.com.arthouseserv.repositories;

import br.com.arthouseserv.models.CaracteristicaProdutoProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaracteristicaProdutoProdutoRepository extends JpaRepository<CaracteristicaProdutoProduto,Integer> {
}
