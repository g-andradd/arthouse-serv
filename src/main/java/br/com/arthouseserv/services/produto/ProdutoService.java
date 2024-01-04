package br.com.arthouseserv.services.produto;

import br.com.arthouseserv.dto.*;
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
import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final TipoProdutoService tipoProdutoService;
    private final ProdutoMapper produtoMapper;
    private final CaracteriticaProdutoService caracteriticaProdutoService;
    private final CaracteristicaProdutoProdutoService caracteristicaProdutoProdutoService;
    private final CorProdutoProdutoService corProdutoProdutoService;
    private final CorProdutoService corProdutoService;

    public ProdutoService(ProdutoRepository produtoRepository, TipoProdutoService tipoProdutoService,
                          ProdutoMapper produtoMapper, CaracteriticaProdutoService caracteriticaProdutoService,
                          CaracteristicaProdutoProdutoService caracteristicaProdutoProdutoService,
                          CorProdutoProdutoService corProdutoProdutoService,
                          CorProdutoService corProdutoService) {
        this.produtoRepository = produtoRepository;
        this.tipoProdutoService = tipoProdutoService;
        this.produtoMapper = produtoMapper;
        this.caracteriticaProdutoService = caracteriticaProdutoService;
        this.caracteristicaProdutoProdutoService = caracteristicaProdutoProdutoService;
        this.corProdutoProdutoService = corProdutoProdutoService;
        this.corProdutoService = corProdutoService;
    }

    public Produto cadastroContProdutos(MultipartFile multipartFile) throws IOException {
        return saveProduto(produtoMapper.produtoDTOToEntityOnlyCont(multipartFile));
    }

    public void cadastroProdutosCompleto(ResponseProdutoDTO responseProdutoDTO) {
        var produto = buscarProduto(responseProdutoDTO.idProduto());
        var tipoProduto = tipoProdutoService.getTipoProduto(responseProdutoDTO.tipoProdutoDTO().idTipoProduto());
        var retornoProdutoSalvo = saveProduto(produtoMapper.produtoDTOToEntityAlteracao(tipoProduto, produto));


        responseProdutoDTO.caracteristicasProdutoDTO().forEach(x -> {
            var caracteristicasProduto = caracteriticaProdutoService.buscarCaracteristicasProduto(x.idCaracteristicasProduto());
            caracteristicaProdutoProdutoService.saveCaracteristicaProdutoProduto(retornoProdutoSalvo, caracteristicasProduto);
        });

        responseProdutoDTO.coresProdutoDTO().forEach(x -> {
            var corProduto = corProdutoService.buscarCoresProduto(x.idCorProduto());
            corProdutoProdutoService.saveCoresProdutoProduto(corProduto, retornoProdutoSalvo);
        });


    }

    public byte[] downloadProdutoById(Integer idProduto) {
        return buscarProduto(idProduto).getContProduto();
    }


    public Produto buscarProduto(Integer idProduto) {
        return produtoRepository.findById(idProduto).orElseThrow(() -> new ProdutosExceptions("Produto não foi encontrado !!"));
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

    public List<CaracteristicasDTO> listarCaracteristicas() {
        return caracteriticaProdutoService.buscarListaCaracteristicas();
    }

    public List<CoresDTO> listarCores() {
        return corProdutoService.buscarListaCores();
    }

    public void salvarImageCaracteristicas(Integer idCaracteristicas, MultipartFile imagem) throws IOException {
        caracteriticaProdutoService.saveImageCaracteristicas(idCaracteristicas,imagem);
    }

    public void salvarImageCores(Integer idCores, MultipartFile imagem) throws IOException {
        corProdutoService.saveImageCores(idCores,imagem);
    }

    public List<CorProdutoDTO> getAllCollors() {
        return corProdutoService.findAll();
    }

    public List<CaracteristicaProdutoDTO> getAllTypes() {
        return caracteriticaProdutoService.findAll();
    }
}
