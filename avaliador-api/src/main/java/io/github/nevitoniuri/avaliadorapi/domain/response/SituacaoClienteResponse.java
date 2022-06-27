package io.github.nevitoniuri.avaliadorapi.domain.response;

import io.github.nevitoniuri.avaliadorapi.domain.model.CartaoVinculado;
import io.github.nevitoniuri.avaliadorapi.domain.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SituacaoClienteResponse {
    private Cliente cliente;
    private List<CartaoVinculado> cartoes;
}
