package io.github.nevitoniuri.avaliadorapi.application;

import io.github.nevitoniuri.avaliadorapi.domain.request.AvaliacaoRequest;
import io.github.nevitoniuri.avaliadorapi.domain.response.AvaliacaoResponse;
import io.github.nevitoniuri.avaliadorapi.domain.response.SituacaoClienteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("avaliacoes")
public class AvaliadorController {

    private final AvaliadorService avaliadorService;

    @GetMapping(value = "situacao", params = "cpf")
    public SituacaoClienteResponse consultaSituacaoCliente(@RequestParam("cpf") String cpf) {
        return avaliadorService.obterSituacaoCliente(cpf);
    }

    @PostMapping
    public AvaliacaoResponse realizarAvaliacao(@RequestBody @Valid AvaliacaoRequest request) {
        return avaliadorService.realizarAvaliacao(request.getCpf(), request.getRenda());
    }
}
