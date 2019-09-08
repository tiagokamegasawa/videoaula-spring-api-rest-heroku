package br.com.fiap.produto.resource;

import br.com.fiap.produto.model.Produto;
import br.com.fiap.produto.service.ProdutoService;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoRestController {

    @Autowired
    private ProdutoService service;

    @PostMapping
    public ResponseEntity<Long> createProduto(
            @RequestBody Produto produto) {
        Produto produtoSave = service.saveProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSave.getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable Long id, @RequestBody Produto produto) {
        Produto existente = service.getOne(id);

        if (existente == null) {
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(produto, existente, "id");

        existente = service.saveProduto(existente);

        return ResponseEntity.ok(existente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/findAll")
    public List<Produto> list() {
        return this.service.findAll();
    }
}
