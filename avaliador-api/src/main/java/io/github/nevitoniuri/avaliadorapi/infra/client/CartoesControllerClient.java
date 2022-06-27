package io.github.nevitoniuri.avaliadorapi.infra.client;

import io.github.nevitoniuri.avaliadorapi.domain.model.Cartao;
import io.github.nevitoniuri.avaliadorapi.domain.model.CartaoVinculado;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "cartoes-api", path = "/cartoes")
public interface CartoesControllerClient {

    @GetMapping(params = "cpf")
    List<CartaoVinculado> listarCartoesVinculados(@RequestParam("cpf") String cpf);

    @GetMapping(params = "renda")
    List<Cartao> buscarCartoesPorRendaMenorIgual(@RequestParam("renda") Long renda);
}
