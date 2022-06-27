package io.github.nevitoniuri.cartoesapi.application.request;

import io.github.nevitoniuri.cartoesapi.domain.BandeiraCartao;
import io.github.nevitoniuri.cartoesapi.domain.Cartao;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class CartaoSalvarRequest {
    @NotBlank
    private String nome;
    @NotNull
    private BandeiraCartao bandeira;
    @NotNull
    private BigDecimal rendaMinima;
    @NotNull
    private BigDecimal limiteBase;

    public Cartao toModel() {
        return new Cartao(nome, bandeira, rendaMinima, limiteBase);
    }
}
