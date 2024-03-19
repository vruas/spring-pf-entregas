package br.com.fiap.springpfentregas.repository;

import br.com.fiap.springpfentregas.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

    public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    }

