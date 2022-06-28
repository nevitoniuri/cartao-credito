package io.github.nevitoniuri.avaliadorapi.application;

import feign.FeignException;
import io.github.nevitoniuri.avaliadorapi.domain.model.CartaoAprovado;
import io.github.nevitoniuri.avaliadorapi.domain.response.AvaliacaoResponse;
import io.github.nevitoniuri.avaliadorapi.domain.response.SituacaoClienteResponse;
import io.github.nevitoniuri.avaliadorapi.infra.client.CartoesControllerClient;
import io.github.nevitoniuri.avaliadorapi.infra.client.ClienteControllerClient;
import io.github.nevitoniuri.clientesapi.infra.exception.ClienteNaoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class AvaliadorService {

    private final ClienteControllerClient clientesApiClient;
    private final CartoesControllerClient cartoesApiClient;

    /**
     * Este método consulta os dados do cliente no serviço clientes-api, consulta os cartões desse cliente no serviço
     * cartoes-api e retorna a situação do Cliente.
     *
     * @param cpf O CPF do cliente.
     * @return SituacaoClienteResponse
     */
    public SituacaoClienteResponse obterSituacaoCliente(String cpf) throws ClienteNaoEncontradoException {
        try {
            var cliente = clientesApiClient.buscarPorCpf(cpf);
            var cartoesVinculados = cartoesApiClient.listarCartoesVinculados(cpf);
            return SituacaoClienteResponse.builder()
                    .cliente(cliente)
                    .cartoes(cartoesVinculados)
                    .build();
        } catch (FeignException.FeignClientException e) {
            throw new ClienteNaoEncontradoException();
        }
    }

    public AvaliacaoResponse realizarAvaliacao(String cpf, Long renda) {
        try {
            var cliente = clientesApiClient.buscarPorCpf(cpf);
            var cartoesDisponiveis = cartoesApiClient.buscarCartoesPorRendaMenorIgual(renda);
            var listaCartoesAprovados = new ArrayList<CartaoAprovado>();
            cartoesDisponiveis.forEach(cartao -> {
                var limiteBasico = cartao.getLimiteBase();
                var idade = BigDecimal.valueOf(cliente.getIdade());
                var fator = idade.divide(BigDecimal.valueOf(10));
                var limiteAprovado = limiteBasico.multiply(fator).setScale(2, BigDecimal.ROUND_HALF_UP);
                var cartaoAprovado = CartaoAprovado.builder()
                        .cartao(cartao.getNome())
                        .bandeira(cartao.getBandeira())
                        .limiteAprovado(limiteAprovado)
                        .build();
                listaCartoesAprovados.add(cartaoAprovado);
            });
            return AvaliacaoResponse.builder()
                    .cartoesAprovados(listaCartoesAprovados)
                    .build();
        } catch (FeignException.FeignClientException e) {
            throw new ClienteNaoEncontradoException();
        }
    }
}
