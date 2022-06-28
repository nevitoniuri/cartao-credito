package io.github.nevitoniuri.cartoesapi.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DadosSolicitacaoCartao {
    private Long idCartao;
    private String cpf;
    private String endereco;
    private BigDecimal limiteLiberado;
}
