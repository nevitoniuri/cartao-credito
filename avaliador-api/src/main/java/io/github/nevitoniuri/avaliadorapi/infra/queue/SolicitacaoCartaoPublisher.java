package io.github.nevitoniuri.avaliadorapi.infra.queue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.nevitoniuri.avaliadorapi.domain.request.DadosSolicitacaoCartao;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SolicitacaoCartaoPublisher {

    private final RabbitTemplate rabbitTemplate;
    private final Queue emissaoCartoesQueue;

    public void solicitarCartao(DadosSolicitacaoCartao dados) throws JsonProcessingException {
        rabbitTemplate.convertAndSend(emissaoCartoesQueue.getName(), convertToJson(dados));
    }

    private String convertToJson(DadosSolicitacaoCartao dados) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(dados);
    }

}
