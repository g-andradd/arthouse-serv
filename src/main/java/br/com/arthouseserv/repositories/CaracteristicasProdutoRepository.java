package br.com.arthouseserv.repositories;

import br.com.arthouseserv.dto.CaracteristicasDTO;
import br.com.arthouseserv.models.CaracteristicasProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaracteristicasProdutoRepository extends JpaRepository<CaracteristicasProduto, Integer> {

    @Query(" SELECT new br.com.arthouseserv.dto.CaracteristicasDTO(cp.idCaracteristicasProduto," +
            "cp.nomeCaracterisiticasProduto,cp.imgCaracterisiticasProduto) " +
            "FROM CaracteristicasProduto cp")
    List<CaracteristicasDTO> buscarCaracteristicas();
}
