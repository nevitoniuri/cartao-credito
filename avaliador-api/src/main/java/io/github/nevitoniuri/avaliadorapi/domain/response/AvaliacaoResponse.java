package io.github.nevitoniuri.avaliadorapi.domain.response;

import io.github.nevitoniuri.avaliadorapi.domain.model.CartaoAprovado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoResponse {
    private List<CartaoAprovado> cartoesAprovados;
}
