package io.github.nevitoniuri.avaliadorapi.infra.client;

import io.github.nevitoniuri.avaliadorapi.domain.model.Cliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "clientes-api", path = "/clientes")
public interface ClienteControllerClient {

    @GetMapping(params = "cpf")
    Cliente buscarPorCpf(@RequestParam("cpf") String cpf);
}
