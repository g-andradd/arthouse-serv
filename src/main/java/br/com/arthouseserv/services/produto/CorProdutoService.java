package br.com.arthouseserv.services.produto;

import br.com.arthouseserv.dto.CorProdutoDTO;
import br.com.arthouseserv.exception.ProdutosExceptions;
import br.com.arthouseserv.mappers.CorProdutoMapper;
import br.com.arthouseserv.models.CorProduto;
import br.com.arthouseserv.repositories.CorProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CorProdutoService {

    private final CorProdutoRepository corProdutoRepository;
    private final CorProdutoMapper corProdutoMapper;

    public CorProdutoService(CorProdutoRepository corProdutoRepository, CorProdutoMapper corProdutoMapper) {
        this.corProdutoRepository = corProdutoRepository;
        this.corProdutoMapper = corProdutoMapper;
    }

    public CorProduto buscarCoresProduto(Integer idCorProduto){
        return corProdutoRepository.findById(idCorProduto).orElseThrow(() -> new ProdutosExceptions("Cor do produto não encontrado"));
    }

    public List<CorProdutoDTO> findAll() {
        List<CorProduto> coresProduto = corProdutoRepository.findAll();
        return coresProduto.stream()
                .map(corProdutoMapper::toDTO)
                .collect(Collectors.toList());
    }
}
