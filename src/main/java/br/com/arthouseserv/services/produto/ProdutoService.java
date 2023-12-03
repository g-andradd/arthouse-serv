package br.com.arthouseserv.services.produto;

import br.com.arthouseserv.dto.FiltroProdutoDTO;
import br.com.arthouseserv.dto.ProdutosDTO;
import br.com.arthouseserv.dto.ResponseProdutoDTO;
import br.com.arthouseserv.exception.ProdutosExceptions;
import br.com.arthouseserv.mappers.ProdutoMapper;
import br.com.arthouseserv.models.Produto;
import br.com.arthouseserv.repositories.ProdutoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final TipoProdutoService tipoProdutoService;
    private final ProdutoMapper produtoMapper;
    private final CaracteriticasProdutoService caracteriticasProdutoService;
    private final CaracteristicaProdutoProdutoService caracteristicaProdutoProdutoService;
    private final CoresProdutoProdutoService coresProdutoProdutoService;
    private final CoresProdutoService coresProdutoService;

    public ProdutoService(ProdutoRepository produtoRepository, TipoProdutoService tipoProdutoService, ProdutoMapper produtoMapper, CaracteriticasProdutoService caracteriticasProdutoService, CaracteristicaProdutoProdutoService caracteristicaProdutoProdutoService, CoresProdutoProdutoService coresProdutoProdutoService, CoresProdutoService coresProdutoService) {
        this.produtoRepository = produtoRepository;
        this.tipoProdutoService = tipoProdutoService;
        this.produtoMapper = produtoMapper;
        this.caracteriticasProdutoService = caracteriticasProdutoService;
        this.caracteristicaProdutoProdutoService = caracteristicaProdutoProdutoService;
        this.coresProdutoProdutoService = coresProdutoProdutoService;
        this.coresProdutoService = coresProdutoService;
    }

    public Produto cadastroContProdutos(MultipartFile multipartFile) throws IOException {
        return saveProduto(produtoMapper.produtoDTOToEntityOnlyCont(multipartFile));
    }

    public void cadastroProdutosCompleto(ResponseProdutoDTO responseProdutoDTO) {
        var produto = buscarProduto(responseProdutoDTO.idProduto());
        var tipoProduto = tipoProdutoService.getTipoProduto(responseProdutoDTO.tipoProdutoDTO().idTipoProduto());
        var retornoProdutoSalvo = saveProduto(produtoMapper.produtoDTOToEntityAlteracao(tipoProduto, produto));


        responseProdutoDTO.caracteristicasProdutoDTO().forEach(x -> {
            var caracteristicasProduto = caracteriticasProdutoService.buscarCaracteristicasProduto(x.idCaracteristicasProduto());
            caracteristicaProdutoProdutoService.saveCaracteristicaProdutoProduto(retornoProdutoSalvo, caracteristicasProduto);
        });

        responseProdutoDTO.coresProdutoDTO().forEach(x -> {
            var corProduto = coresProdutoService.buscarCoresProduto(x.idCorProduto());
            coresProdutoProdutoService.saveCoresProdutoProduto(corProduto, retornoProdutoSalvo);
        });


    }

    public byte[] downloadProdutoById(Integer idProduto) {
        return buscarProduto(idProduto).getContProduto();
    }


    public Produto buscarProduto(Integer idProduto) {
        return produtoRepository.findById(idProduto).orElseThrow(() -> new ProdutosExceptions("Produto não foi encontrado !!" ));
    }


    public Produto saveProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Page<ProdutosDTO> buscarProdutosPagebleFiltro(FiltroProdutoDTO filtroProdutoDTO, Integer pages, Integer size) {
        Pageable page = PageRequest.of(pages, size);
        var cores = filtroProdutoDTO.cores().isEmpty() ? null : filtroProdutoDTO.cores();
        var caracteristicas = filtroProdutoDTO.caracteristicas().isEmpty() ? null : filtroProdutoDTO.caracteristicas();
        return produtoRepository.getProdutosFiltro(cores, caracteristicas, page);


    }
}
