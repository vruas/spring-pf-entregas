package br.com.fiap.springpfentregas.resource;

import br.com.fiap.springpfentregas.entity.Pessoa;
import br.com.fiap.springpfentregas.repository.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaResource {

    @Autowired
    private PessoaRepository repoPessoa;

    @GetMapping
    public List<Pessoa> findAll() {
        return repoPessoa.findAll();
    }

    @GetMapping(value = "/{id}")
    public Pessoa findById(@PathVariable Long id) {
        return repoPessoa.findById(id).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Pessoa save(@RequestBody Pessoa pessoa) {
        if(Objects.isNull(pessoa)) return null;
        pessoa.setId(null);

        return repoPessoa.save(pessoa);
    }
}
