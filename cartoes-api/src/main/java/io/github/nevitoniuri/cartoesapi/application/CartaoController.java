package io.github.nevitoniuri.cartoesapi.application;

import io.github.nevitoniuri.cartoesapi.application.request.CartaoSalvarRequest;
import io.github.nevitoniuri.cartoesapi.domain.Cartao;
import io.github.nevitoniuri.cartoesapi.domain.CartaoVinculado;
import io.github.nevitoniuri.cartoesapi.domain.dto.CartaoDTO;
import io.github.nevitoniuri.cartoesapi.domain.dto.CartaoVinculadoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("cartoes")
public class CartaoController {

    private final CartaoService cartaoService;
    private final CartaoVinculadoService cartaoVinculadoService;

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody @Valid CartaoSalvarRequest cartao) {
        cartaoService.salvar(cartao.toModel());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "renda")
    public List<CartaoDTO> buscarPorRendaMenorIgual(@RequestParam("renda") Long renda) {
        List<Cartao> cartoes = cartaoService.buscarPorRendaMenorIgual(renda);
        return new CartaoDTO().toDTOList(cartoes);
    }

    @GetMapping(params = "cpf")
    public List<CartaoVinculadoDTO> listarCartoesVinculados(@RequestParam("cpf") String cpf) {
        List<CartaoVinculado> cartaoVinculados = cartaoVinculadoService.listarPorCpf(cpf);
        return cartaoVinculados.stream().map(CartaoVinculadoDTO::toDTO)
                .collect(Collectors.toList());
    }
}
