package br.com.arthouseserv.services.produto;

import br.com.arthouseserv.exception.ProdutosExceptions;
import br.com.arthouseserv.models.CaracteristicasProduto;
import br.com.arthouseserv.repositories.CaracteristicasProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class CaracteriticasProdutoService {

   private final CaracteristicasProdutoRepository caracteristicasProdutoRepository;

    public CaracteriticasProdutoService(CaracteristicasProdutoRepository caracteristicasProdutoRepository) {
        this.caracteristicasProdutoRepository = caracteristicasProdutoRepository;
    }

    public CaracteristicasProduto buscarCaracteristicasProduto(Integer idCaracteristicasProduto){
        return  caracteristicasProdutoRepository.findById(idCaracteristicasProduto).orElseThrow(() -> new ProdutosExceptions("Caracteristicas do produto não foi encontrada!"));
    }
}
