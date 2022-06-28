package io.github.nevitoniuri.avaliadorapi.domain.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CartaoVinculado {
    private Long id;
    private String nome;
    private String bandeira;
    private BigDecimal limite;
    private LocalDateTime dataVinculacao;
}
