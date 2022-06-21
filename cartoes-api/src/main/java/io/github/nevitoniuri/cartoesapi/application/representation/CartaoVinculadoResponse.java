package io.github.nevitoniuri.cartoesapi.application.representation;

import io.github.nevitoniuri.cartoesapi.domain.CartaoVinculado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartaoVinculadoResponse {
    private String nome;
    private String bandeira;
    private BigDecimal limite;
    private LocalDateTime dataVinculacao;

    public static CartaoVinculadoResponse of(CartaoVinculado cartaoVinculado) {
        CartaoVinculadoResponse response = new CartaoVinculadoResponse();
        response.setNome(cartaoVinculado.getCartao().getNome());
        response.setBandeira(cartaoVinculado.getCartao().getBandeira().toString());
        response.setLimite(cartaoVinculado.getCartao().getLimite());
        response.setDataVinculacao(cartaoVinculado.getDataVinculacao());
        return response;
    }
}
