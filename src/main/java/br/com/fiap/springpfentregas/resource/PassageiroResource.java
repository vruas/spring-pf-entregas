package br.com.fiap.springpfentregas.resource;

import br.com.fiap.springpfentregas.entity.Passageiro;
import br.com.fiap.springpfentregas.repository.PassageiroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/passageiro")
public class PassageiroResource {

    @Autowired
    private PassageiroRepository repoPassageiro;

    @GetMapping
    public List<Passageiro> findAll() {
        return repoPassageiro.findAll();
    }

    @GetMapping(value = "/{id}")
    public Passageiro findById(@PathVariable Long id) {
        return repoPassageiro.findById(id).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Passageiro save(@RequestBody Passageiro passageiro) {
        if(Objects.isNull(passageiro)) return null;
        passageiro.setId(null);

        return repoPassageiro.save(passageiro);
    }



}
