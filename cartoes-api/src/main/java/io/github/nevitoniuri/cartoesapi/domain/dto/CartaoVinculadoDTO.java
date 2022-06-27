package io.github.nevitoniuri.cartoesapi.domain.dto;

import io.github.nevitoniuri.cartoesapi.domain.CartaoVinculado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartaoVinculadoDTO {
    private String nome;
    private String bandeira;
    private BigDecimal limite;
    private LocalDateTime dataVinculacao;

    public static CartaoVinculadoDTO toDTO(CartaoVinculado cartaoVinculado) {
        CartaoVinculadoDTO response = new CartaoVinculadoDTO();
        response.setNome(cartaoVinculado.getCartao().getNome());
        response.setBandeira(cartaoVinculado.getCartao().getBandeira().toString());
        response.setLimite(cartaoVinculado.getCartao().getLimiteBase());
        response.setDataVinculacao(cartaoVinculado.getDataVinculacao());
        return response;
    }
}
