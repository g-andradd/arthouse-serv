package br.com.arthouseserv.services.produto;

import br.com.arthouseserv.dto.CaracteristicasDTO;
import br.com.arthouseserv.dto.CoresDTO;
import br.com.arthouseserv.exception.ProdutosExceptions;
import br.com.arthouseserv.models.CoresProduto;
import br.com.arthouseserv.repositories.CoresProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CoresProdutoService {

    private final CoresProdutoRepository coresProdutoRepository;


    public CoresProdutoService(CoresProdutoRepository coresProdutoRepository) {
        this.coresProdutoRepository = coresProdutoRepository;
    }


    public CoresProduto buscarCoresProduto(Integer idCorProduto){
        return coresProdutoRepository.findById(idCorProduto).orElseThrow(() -> new ProdutosExceptions("Cor do produto não encontrado"));
    }

    public List<CoresDTO> buscarListaCores(){
        return coresProdutoRepository.buscarCores();
    }

    public void saveImageCores(Integer idCores, MultipartFile imagem) throws IOException {
        var cores = buscarCoresProduto(idCores);
        cores.setImgCorProduto(imagem.getBytes());
        coresProdutoRepository.save(cores);
    }

}
