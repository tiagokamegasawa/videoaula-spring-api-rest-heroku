package br.com.fiap.produto.service;

import br.com.fiap.produto.model.Produto;
import br.com.fiap.produto.repository.ProdutoRepository;
import java.util.List;
import java.util.Optional;
import javax.swing.text.html.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto saveProduto(Produto produto ) {
        return repository.save(produto);
    }

    public Produto getOne(Long id) {
        return this.repository.getOne(id);
    }

    public Optional<Produto> findById(Long id) {
        return this.repository.findById(id);
    }

    public List<Produto> findAll(){
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.delete(repository.getOne(id));
    }

}


