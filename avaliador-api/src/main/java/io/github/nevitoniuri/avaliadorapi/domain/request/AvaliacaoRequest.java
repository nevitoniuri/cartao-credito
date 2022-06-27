package io.github.nevitoniuri.avaliadorapi.domain.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AvaliacaoRequest {
    @NotBlank(message = "O cpf é obrigatório")
    private String cpf;
    @NotNull(message = "A renda é obrigatória")
    private Long renda;
}
