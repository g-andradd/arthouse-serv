package br.com.arthouseserv.services.produto;

import br.com.arthouseserv.models.CoresProduto;
import br.com.arthouseserv.models.CoresProdutoProduto;
import br.com.arthouseserv.models.Produto;
import br.com.arthouseserv.repositories.CoresProdutoProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class CoresProdutoProdutoService {

    private final CoresProdutoProdutoRepository coresProdutoProdutoRepository;

    public CoresProdutoProdutoService(CoresProdutoProdutoRepository coresProdutoProdutoRepository) {
        this.coresProdutoProdutoRepository = coresProdutoProdutoRepository;
    }

    public void saveCoresProdutoProduto(CoresProduto coresProduto, Produto produto){
        coresProdutoProdutoRepository.save(new CoresProdutoProduto(coresProduto,produto));
    }
}
