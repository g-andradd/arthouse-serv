package br.com.arthouseserv.controller;

import br.com.arthouseserv.dto.FiltroProdutoDTO;
import br.com.arthouseserv.dto.ResponseCalculoQuantidade;
import br.com.arthouseserv.dto.ResponseProdutoDTO;
import br.com.arthouseserv.services.produto.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/produto")
@CrossOrigin
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping(value = "/cadastro/image", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> cadastroImagePapeisDeParede(@RequestParam("anexo") MultipartFile multipartFile) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.cadastroContProdutos(multipartFile));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @PostMapping(value = "/cadastro")
    public ResponseEntity<?> cadastroPapeisDeParede(@RequestBody ResponseProdutoDTO responseProdutoDTO) {
        try {
            produtoService.cadastroProdutosCompleto(responseProdutoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Produto salvo com Sucesso!!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @GetMapping(value = "/download", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<?> downloadProduto(@RequestParam("idProduto") Integer idProduto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(produtoService.downloadProdutoById(idProduto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/filtro")
    public ResponseEntity<?> filtroProdutos(@RequestBody FiltroProdutoDTO filtroProdutoDTO,
                                            @RequestPart(value = "page", required = false) Integer page,
                                            @RequestPart(value = "size", required = false) Integer size) {
        try {
            page = page == null ? 0 : page;
            size = size == null ? 10 : size;

            return ResponseEntity.status(HttpStatus.OK).body(produtoService.buscarProdutosPagebleFiltro(filtroProdutoDTO, page, size));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @GetMapping("/filtro/caracteristicas")
    public ResponseEntity<?> listarCaracteriticas() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(produtoService.listarCaracteristicas());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/filtro/cores")
    public ResponseEntity<?> listarCores() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(produtoService.listarCores());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/cadastro/image/caracteristicas/{idCaracteristicas}")
    public ResponseEntity<?> adicionaImgsCaracteristicas(@RequestParam("imagem") MultipartFile multipartFile,
                                                         @PathVariable("idCaracteristicas") Integer idCaracteristicas) {
        try {
            produtoService.salvarImageCaracteristicas(idCaracteristicas, multipartFile);
            return ResponseEntity.status(HttpStatus.OK).body("Imagem salva com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/cadastro/image/cores/{idCores}")
    public ResponseEntity<?> adicionaImgsCores(@RequestParam("imagem") MultipartFile multipartFile,
                                               @PathVariable("idCores") Integer idCores) {
        try {
            produtoService.salvarImageCores(idCores, multipartFile);
            return ResponseEntity.status(HttpStatus.OK).body("Imagem salva com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/calculo-quantidade")
    public ResponseEntity<?> calculaQuantidadedeRolos(@RequestBody ResponseCalculoQuantidade responseCalculoQuantidade) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(produtoService.calculoQuantidadeRolos(responseCalculoQuantidade));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
