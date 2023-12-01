package br.com.arthouseserv.controller;

import br.com.arthouseserv.dto.FiltroProdutoDTO;
import br.com.arthouseserv.dto.ResponseProdutoDTO;
import br.com.arthouseserv.services.produto.ProdutoService;
import jakarta.websocket.server.PathParam;
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
            return ResponseEntity.status(HttpStatus.OK).body(produtoService.cadastroContProdutos(multipartFile));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @PostMapping(value = "/cadastro")
    public ResponseEntity<?> cadastroPapeisDeParede(@RequestBody ResponseProdutoDTO responseProdutoDTO) {
        try {
            produtoService.cadastroProdutosCompleto(responseProdutoDTO);
            return ResponseEntity.status(HttpStatus.OK).body("Produto salvo com Sucesso!!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @GetMapping(value = "/download",produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<?> downloadProduto(@RequestParam("idProduto") Integer idProduto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(produtoService.downloadProdutoById(idProduto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @GetMapping("/filtro")
    public ResponseEntity<?> filtroProdutos(@RequestBody FiltroProdutoDTO filtroProdutoDTO,
                                            @PathParam("page") Integer page,
                                            @PathParam("size") Integer size) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(produtoService.buscarProdutosPagebleFiltro(filtroProdutoDTO,page,size));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }



}
