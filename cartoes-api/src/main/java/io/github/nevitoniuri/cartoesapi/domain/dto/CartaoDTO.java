package io.github.nevitoniuri.cartoesapi.domain.dto;

import io.github.nevitoniuri.cartoesapi.domain.Cartao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartaoDTO {
    private Long id;
    private String nome;
    private String bandeira;
    private BigDecimal rendaMinima;
    private BigDecimal limiteBase;

    public CartaoDTO toDTO(Cartao cartao) {
        return CartaoDTO.builder()
                .id(cartao.getId())
                .nome(cartao.getNome())
                .bandeira(cartao.getBandeira().toString())
                .rendaMinima(cartao.getRendaMinima())
                .limiteBase(cartao.getLimiteBase())
                .build();
    }

    public List<CartaoDTO> toDTOList(List<Cartao> cartoes) {
        return cartoes.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
