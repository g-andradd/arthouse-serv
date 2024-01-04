package br.com.arthouseserv.services.produto;

import br.com.arthouseserv.models.CorProduto;
import br.com.arthouseserv.models.CorProdutoProduto;
import br.com.arthouseserv.models.Produto;
import br.com.arthouseserv.repositories.CorProdutoProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class CorProdutoProdutoService {

    private final CorProdutoProdutoRepository coresProdutoProdutoRepository;

    public CorProdutoProdutoService(CorProdutoProdutoRepository coresProdutoProdutoRepository) {
        this.coresProdutoProdutoRepository = coresProdutoProdutoRepository;
    }

    public void saveCoresProdutoProduto(CorProduto coresProduto, Produto produto){
        coresProdutoProdutoRepository.save(new CorProdutoProduto(coresProduto,produto));
    }
}
