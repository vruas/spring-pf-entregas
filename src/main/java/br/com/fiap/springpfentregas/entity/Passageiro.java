package br.com.fiap.springpfentregas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TB_CP1_PASSAGEIRO")
public class Passageiro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PASSAGEIRO")
    @SequenceGenerator(
            name = "SQ_PASSAGEIRO",
            sequenceName = "SQ_PASSAGEIRO",
            initialValue = 1,
            allocationSize = 50
    )
    @Column(name = "ID_PASSAGEIRO")
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "PASSAGEIRO_PESSOA",
            referencedColumnName = "ID_PESSOA",
            foreignKey = @ForeignKey(name = "FK_PASSAGEIRO_PESSOA"))
    private Pessoa pessoa;
}
