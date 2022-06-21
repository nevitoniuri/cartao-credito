package io.github.nevitoniuri.cartoesapi.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class CartaoVinculado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "cartao_id")
    private Cartao cartao;
    private BigDecimal limite;
    private LocalDateTime dataVinculacao;

    @PrePersist
    private void prePersist() {
        this.dataVinculacao = LocalDateTime.now();
    }

}
