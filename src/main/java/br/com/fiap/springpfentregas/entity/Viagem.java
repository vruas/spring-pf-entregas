package br.com.fiap.springpfentregas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_CP1_VIAGEM")

public class Viagem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_VIAGEM")
    @SequenceGenerator(
            name = "SQ_VIAGEM",
            sequenceName = "SQ_VIAGEM",
            initialValue = 1,
            allocationSize = 1
    )
    @Column(name = "ID_VIAGEM")
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "TB_CP1_PRODUTO",
            joinColumns = {
                    @JoinColumn(name = "VIAGEM",
                            referencedColumnName = "ID_VIAGEM",
                            foreignKey = @ForeignKey(name = "FK_PRODUTO_VIAGEM"

                            )
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "PRODUTO",
                            referencedColumnName = "ID_PRODUTO",
                            foreignKey = @ForeignKey(
                                    name = "FK_VIAGEM_PRODUTO"

                            )
                    )
            }
    )
    private List<Produto> produtos = new ArrayList<>();


    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "TB_CP1_PASSAGEIRO",
            joinColumns = {
                    @JoinColumn(name = "VIAGEM",
                            referencedColumnName = "ID_VIAGEM",
                            foreignKey = @ForeignKey(name = "FK_PASSAGEIRO_VIAGEM"

                            )
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "PASSAGEIRO",
                            referencedColumnName = "ID_PASSAGEIRO",
                            foreignKey = @ForeignKey(
                                    name = "FK_VIAGEM_PASSAGEIRO"

                            )
                    )
            }
    )
    private List<Passageiro> passageiros = new ArrayList<>();


    @OneToOne
    @JoinColumn(
            name = "ID_CLIENTE",
            referencedColumnName = "ID_PESSOA",
            foreignKey = @ForeignKey(name = "FK_VIAGEM_CLIENTE")
    )
    private Pessoa cliente;

    @ManyToOne
    @JoinColumn(name = "ID_ORIGEM", referencedColumnName = "ID_ENDERECO", foreignKey = @ForeignKey(name = "FK_VIAGEM_ORIGEM"))
    private Endereco origem;

    @ManyToOne
    @JoinColumn(name = "ID_DESTINO", referencedColumnName = "ID_ENDERECO", foreignKey = @ForeignKey(name = "FK_VIAGEM_DESTINO"))
    private Endereco destino;

    @Column(name =  "SAIDA")
    private LocalDate saida;

    @Column(name =  "CHEGADA")
    private LocalDate chegada;
}
