package io.github.nevitoniuri.cartoesapi.application;

import io.github.nevitoniuri.cartoesapi.application.representation.CartaoSalvarRequest;
import io.github.nevitoniuri.cartoesapi.application.representation.CartaoVinculadoResponse;
import io.github.nevitoniuri.cartoesapi.domain.Cartao;
import io.github.nevitoniuri.cartoesapi.domain.CartaoVinculado;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("cartoes")
public class CartaoResource {

    private final CartaoService cartaoService;
    private final CartaoVinculadoService cartaoVinculadoService;

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody CartaoSalvarRequest cartao) {
        cartaoService.salvar(cartao.toModel());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "renda")
    public List<Cartao> buscarPorRendaMenorIgual(@RequestParam("renda") Long renda) {
        return cartaoService.buscarPorRendaMenorIgual(renda);
    }

    @GetMapping(params = "cpf")
    public List<CartaoVinculadoResponse> listarCartoesVinculados(@RequestParam("cpf") String cpf) {
        List<CartaoVinculado> cartaoVinculados = cartaoVinculadoService.listarPorCpf(cpf);
        return cartaoVinculados.stream().map(CartaoVinculadoResponse::of)
                .collect(Collectors.toList());
    }
}
