package io.github.nevitoniuri.avaliadorapi.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    @Value("${mq.queues.emissao-cartoes}")
    private String emissaoCartoesQueue;

    public Queue emissaoCartoesQueue() {
        return new Queue(emissaoCartoesQueue, true);
    }
}
