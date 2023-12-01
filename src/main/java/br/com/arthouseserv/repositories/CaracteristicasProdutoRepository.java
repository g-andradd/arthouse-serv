package br.com.arthouseserv.repositories;

import br.com.arthouseserv.models.CaracteristicasProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaracteristicasProdutoRepository extends JpaRepository<CaracteristicasProduto,Integer> {
}
