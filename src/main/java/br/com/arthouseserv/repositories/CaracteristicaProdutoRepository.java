package br.com.arthouseserv.repositories;

import br.com.arthouseserv.models.CaracteristicaProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaracteristicaProdutoRepository extends JpaRepository<CaracteristicaProduto,Integer> {
}
