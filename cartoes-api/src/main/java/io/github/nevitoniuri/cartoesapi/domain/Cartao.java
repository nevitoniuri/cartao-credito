package io.github.nevitoniuri.cartoesapi.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
public class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private BandeiraCartao bandeira;
    private BigDecimal rendaMinima;
    private BigDecimal limiteBase;

    public Cartao(String nome, BandeiraCartao bandeira, BigDecimal rendaMinima, BigDecimal limiteBase) {
        this.nome = nome;
        this.bandeira = bandeira;
        this.rendaMinima = rendaMinima;
        this.limiteBase = limiteBase;
    }
}
