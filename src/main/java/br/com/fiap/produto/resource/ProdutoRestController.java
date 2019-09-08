package br.com.fiap.produto.resource;

import br.com.fiap.produto.model.Produto;
import br.com.fiap.produto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoRestController {

    @Autowired
    private ProdutoService service;

    @PostMapping()
    public ResponseEntity<Long> createProduto(
            @RequestBody Produto produto) {
        Produto produtoSave = service.createProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSave.getId());
    }

}
