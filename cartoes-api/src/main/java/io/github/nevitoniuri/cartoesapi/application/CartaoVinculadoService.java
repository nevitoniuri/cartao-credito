package io.github.nevitoniuri.cartoesapi.application;

import io.github.nevitoniuri.cartoesapi.domain.Cartao;
import io.github.nevitoniuri.cartoesapi.domain.CartaoVinculado;
import io.github.nevitoniuri.cartoesapi.domain.DadosSolicitacaoCartao;
import io.github.nevitoniuri.cartoesapi.infra.repository.CartaoVinculadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartaoVinculadoService {

    private final CartaoVinculadoRepository repository;
    private final CartaoService cartaoService;

    public List<CartaoVinculado> listarPorCpf(String cpf) {
        return repository.findByCpf(cpf);
    }

    public void vincularCartao(DadosSolicitacaoCartao dados) {
        Cartao cartao = cartaoService.buscarPorId(dados.getIdCartao());
        CartaoVinculado cartaoVinculado = CartaoVinculado.builder()
                .cartao(cartao)
                .cpf(dados.getCpf())
                .limite(dados.getLimiteLiberado())
                .build();
        repository.save(cartaoVinculado);
    }
}
