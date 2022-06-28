package io.github.nevitoniuri.clientesapi.application;

import io.github.nevitoniuri.clientesapi.application.request.ClienteSaveRequest;
import io.github.nevitoniuri.clientesapi.domain.Cliente;
import io.github.nevitoniuri.clientesapi.infra.util.ClienteCriado;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("clientes")
public class ClienteController {

    private final ClienteService service;

    @GetMapping(params = "cpf")
    public Cliente buscarPorCpf(@RequestParam("cpf") String cpf) {
        return service.buscarPorCpf(cpf);
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody ClienteSaveRequest request) {
        var clienteSalvo = service.salvar(request.toCliente());
        return ResponseEntity.created(ClienteCriado.location(clienteSalvo.getCpf())).build();
    }

}
