package br.com.arthouseserv.mappers;

import br.com.arthouseserv.dto.CaracteristicaProdutoDTO;
import br.com.arthouseserv.dto.CorProdutoDTO;
import br.com.arthouseserv.models.CaracteristicaProduto;
import br.com.arthouseserv.models.CorProduto;
import org.springframework.stereotype.Component;

@Component
public class CaracteristicaProdutoMapper {

    public CaracteristicaProdutoDTO toDTO(CaracteristicaProduto caracteristicaProduto) {
        return new CaracteristicaProdutoDTO(
                caracteristicaProduto.getIdCaracteristicasProduto(),
                caracteristicaProduto.getNomeCaracterisiticasProduto()
        );
    }

}
