package br.com.arthouseserv.repositories;

import br.com.arthouseserv.dto.CaracteristicasDTO;
import br.com.arthouseserv.dto.CoresDTO;
import br.com.arthouseserv.models.CoresProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoresProdutoRepository extends JpaRepository<CoresProduto,Integer> {


    @Query(" SELECT new br.com.arthouseserv.dto.CoresDTO(cp.idCorProduto," +
            "cp.nomeCorProduto,cp.imgCorProduto) " +
            "FROM CoresProduto cp")
    List<CoresDTO> buscarCores();


}
