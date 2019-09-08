package br.com.fiap.produto.service;

import br.com.fiap.produto.model.Produto;
import br.com.fiap.produto.repository.ProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto createProduto(Produto produto ) {
        return repository.save(produto);
    }

    public List<Produto> findAll(){
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.delete(repository.getOne(id));
    }

}


