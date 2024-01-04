package br.com.arthouseserv.services.produto;

import br.com.arthouseserv.models.CaracteristicaProdutoProduto;
import br.com.arthouseserv.models.CaracteristicaProduto;
import br.com.arthouseserv.models.Produto;
import br.com.arthouseserv.repositories.CaracteristicaProdutoProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class CaracteristicaProdutoProdutoService {

    private final CaracteristicaProdutoProdutoRepository caracteristicaProdutoProdutoRepository;

    public CaracteristicaProdutoProdutoService(CaracteristicaProdutoProdutoRepository caracteristicaProdutoProdutoRepository) {
        this.caracteristicaProdutoProdutoRepository = caracteristicaProdutoProdutoRepository;
    }

    public void saveCaracteristicaProdutoProduto(Produto produto, CaracteristicaProduto caracteristicasProduto){
        caracteristicaProdutoProdutoRepository.save(new CaracteristicaProdutoProduto(caracteristicasProduto,produto));
    }
}
