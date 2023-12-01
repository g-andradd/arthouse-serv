package br.com.arthouseserv.services.produto;

import br.com.arthouseserv.exception.ProdutosExceptions;
import br.com.arthouseserv.models.CoresProduto;
import br.com.arthouseserv.repositories.CoresProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class CoresProdutoService {

    private final CoresProdutoRepository coresProdutoRepository;


    public CoresProdutoService(CoresProdutoRepository coresProdutoRepository) {
        this.coresProdutoRepository = coresProdutoRepository;
    }


    public CoresProduto buscarCoresProduto(Integer idCorProduto){
        return coresProdutoRepository.findById(idCorProduto).orElseThrow(() -> new ProdutosExceptions("Cor do produto não encontrado"));
    }
}
