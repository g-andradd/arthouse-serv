package br.com.arthouseserv.mappers;

import br.com.arthouseserv.dto.CaracteristicasProdutoDTO;
import br.com.arthouseserv.models.CaracteristicasProduto;
import org.springframework.stereotype.Component;

@Component
public class CaracteriticasProdutoMapper {


    public CaracteristicasProdutoDTO toDTO(CaracteristicasProduto caracteristicasProduto) {
        return new CaracteristicasProdutoDTO(caracteristicasProduto.getIdCaracteristicasProduto(),
                caracteristicasProduto.getNomeCaracterisiticasProduto());
    }
}
