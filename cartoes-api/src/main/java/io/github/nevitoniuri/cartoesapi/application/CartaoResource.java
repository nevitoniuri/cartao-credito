package io.github.nevitoniuri.cartoesapi.application;

import io.github.nevitoniuri.cartoesapi.application.representation.CartaoSalvarRequest;
import io.github.nevitoniuri.cartoesapi.domain.Cartao;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("cartoes")
public class CartaoResource {

    private final CartaoService service;

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody CartaoSalvarRequest cartao) {
        service.salvar(cartao.toModel());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "renda")
    public List<Cartao> buscarPorRendaMenorIgual (@RequestParam("renda") Long renda) {
        return service.buscarPorRendaMenorIgual(renda);
    }
}
