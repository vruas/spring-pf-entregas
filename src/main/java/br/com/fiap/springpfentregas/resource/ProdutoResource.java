package br.com.fiap.springpfentregas.resource;

import br.com.fiap.springpfentregas.entity.Produto;
import br.com.fiap.springpfentregas.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoResource {

    @Autowired
    private ProdutoRepository repoProduto;
    @GetMapping
    public List<Produto> findAll() {
        return repoProduto.findAll();
    }

    @GetMapping(value = "/{id}")
    public Produto findById(@PathVariable Long id) {
        return repoProduto.findById(id).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Produto save(@RequestBody Produto produto) {
        if(Objects.isNull(produto)) return null;
        produto.setId(null);

        return repoProduto.save(produto);
    }
}
