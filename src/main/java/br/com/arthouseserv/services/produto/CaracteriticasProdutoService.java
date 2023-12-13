package br.com.arthouseserv.services.produto;

import br.com.arthouseserv.dto.CaracteristicasDTO;
import br.com.arthouseserv.exception.ProdutosExceptions;
import br.com.arthouseserv.models.CaracteristicasProduto;
import br.com.arthouseserv.repositories.CaracteristicasProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CaracteriticasProdutoService {

    private final CaracteristicasProdutoRepository caracteristicasProdutoRepository;

    public CaracteriticasProdutoService(CaracteristicasProdutoRepository caracteristicasProdutoRepository) {
        this.caracteristicasProdutoRepository = caracteristicasProdutoRepository;
    }

    public CaracteristicasProduto buscarCaracteristicasProduto(Integer idCaracteristicasProduto) {
        return caracteristicasProdutoRepository.findById(idCaracteristicasProduto).orElseThrow(() -> new ProdutosExceptions("Caracteristicas do produto não foi encontrada!"));
    }

    public List<CaracteristicasDTO> buscarListaCaracteristicas() {
        return caracteristicasProdutoRepository.buscarCaracteristicas();
    }

    public void saveImageCaracteristicas(Integer idCaracteristicas, MultipartFile imagem) throws IOException {
        var caracteristicas = buscarCaracteristicasProduto(idCaracteristicas);
        caracteristicas.setImgCaracterisiticasProduto(imagem.getBytes());
        caracteristicasProdutoRepository.save(caracteristicas);
    }
}
