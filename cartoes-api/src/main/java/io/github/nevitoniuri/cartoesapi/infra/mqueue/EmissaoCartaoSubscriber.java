package io.github.nevitoniuri.cartoesapi.infra.mqueue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.nevitoniuri.cartoesapi.application.CartaoVinculadoService;
import io.github.nevitoniuri.cartoesapi.domain.DadosSolicitacaoCartao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EmissaoCartaoSubscriber {

    private final CartaoVinculadoService cartaoVinculadoService;

    @RabbitListener(queues = "${mq.queues.emissao-cartoes}")
    public void receive(@Payload String payload) {
        try {
            var mapper = new ObjectMapper();
            DadosSolicitacaoCartao dados = mapper.readValue(payload, DadosSolicitacaoCartao.class);
            cartaoVinculadoService.vincularCartao(dados);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
