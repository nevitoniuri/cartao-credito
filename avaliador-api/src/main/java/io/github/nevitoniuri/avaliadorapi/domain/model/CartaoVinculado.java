package io.github.nevitoniuri.avaliadorapi.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CartaoVinculado {
    private Long id;
    private String nome;
    private String bandeira;
    private BigDecimal limite;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("dataSolicitacao")
    private LocalDateTime dataVinculacao;
}
