package br.com.fiap.springpfentregas.resource;

import br.com.fiap.springpfentregas.entity.Endereco;
import br.com.fiap.springpfentregas.entity.Pessoa;
import br.com.fiap.springpfentregas.repository.EnderecoRepository;
import br.com.fiap.springpfentregas.repository.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoResource {

    @Autowired
    private EnderecoRepository repoEndereco;

    @Autowired
    private PessoaRepository repoPessoa;

    @GetMapping(value = "/cep/{cep}")
    public List<Endereco> findByCep(@PathVariable String cep) {
        List<Endereco> end = repoEndereco.findAll();
        List<Long> id = new ArrayList<>();
        for (Endereco e : end) {
            if (e.getCep().equals(cep)) {
                id.add(e.getId());
            }
        }

        return repoEndereco.findAllById(id);

    }

    @GetMapping(value = "/pessoa/{idPessoa}")
    public Endereco findByIdPessoa(@PathVariable Long idPessoa) {
        Pessoa pessoa = repoPessoa.findById(idPessoa).orElseThrow();
        return repoEndereco.findById(pessoa.getId()).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Endereco save(@RequestBody Endereco endereco) {
        if(Objects.isNull(endereco)) return null;
        endereco.setId(null);

        return repoEndereco.save(endereco);
    }
}
