package io.github.nevitoniuri.cartoesapi.domain.dto;

import io.github.nevitoniuri.cartoesapi.domain.CartaoVinculado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartaoVinculadoDTO {
    private Long id;
    private String nome;
    private String bandeira;
    private BigDecimal limite;
    private LocalDateTime dataVinculacao;

    public static CartaoVinculadoDTO toDTO(CartaoVinculado cartaoVinculado) {
        return CartaoVinculadoDTO.builder()
                .id(cartaoVinculado.getId())
                .nome(cartaoVinculado.getCartao().getNome())
                .bandeira(cartaoVinculado.getCartao().getBandeira().toString())
                .limite(cartaoVinculado.getLimite())
                .dataVinculacao(cartaoVinculado.getDataVinculacao())
                .build();
    }
}
