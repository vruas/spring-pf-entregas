package br.com.fiap.springpfentregas.resource;

import br.com.fiap.springpfentregas.entity.Viagem;
import br.com.fiap.springpfentregas.repository.ViagemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/viagem")
public class ViagemResource {

    @Autowired
    private ViagemRepository repoViagem;
    @GetMapping
    public List<Viagem> findAll() {
        return repoViagem.findAll();
    }

    @GetMapping(value = "/{id}")
    public Viagem findById(@PathVariable Long id) {
        return repoViagem.findById(id).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Viagem save(@RequestBody Viagem viagem) {
        if(Objects.isNull(viagem)) return null;
        viagem.setId(null);

        return repoViagem.save(viagem);
    }
}
