package br.com.arthouseserv.services.produto;

import br.com.arthouseserv.dto.CaracteristicaProdutoDTO;
import br.com.arthouseserv.exception.ProdutosExceptions;
import br.com.arthouseserv.mappers.CaracteristicaProdutoMapper;
import br.com.arthouseserv.models.CaracteristicaProduto;
import br.com.arthouseserv.repositories.CaracteristicaProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CaracteriticaProdutoService {

    private final CaracteristicaProdutoRepository caracteristicaProdutoRepository;
    private final CaracteristicaProdutoMapper caracteristicaProdutoMapper;

    public CaracteriticaProdutoService(CaracteristicaProdutoRepository caracteristicaProdutoRepository, CaracteristicaProdutoMapper caracteristicaProdutoMapper) {
        this.caracteristicaProdutoRepository = caracteristicaProdutoRepository;
        this.caracteristicaProdutoMapper = caracteristicaProdutoMapper;
    }

    public CaracteristicaProduto buscarCaracteristicasProduto(Integer idCaracteristicasProduto) {
        return caracteristicaProdutoRepository.findById(idCaracteristicasProduto).orElseThrow(() -> new ProdutosExceptions("Caracteristicas do produto não foi encontrada!"));
    }

    public List<CaracteristicaProdutoDTO> findAll() {
        List<CaracteristicaProduto> caracteristicasProduto = caracteristicaProdutoRepository.findAll();
        return caracteristicasProduto.stream()
                .map(caracteristicaProdutoMapper::toDTO)
                .collect(Collectors.toList());
    }
}
