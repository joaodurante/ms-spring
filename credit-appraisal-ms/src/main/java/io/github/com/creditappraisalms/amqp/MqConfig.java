package io.github.com.creditappraisalms.amqp;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqConfig {
    @Value("${mq.queues.card-issuance}")
    private String CARD_ISSUANCE_QUEUE;

    @Bean
    public Queue cardIssuanceQueue() {
        return new Queue(CARD_ISSUANCE_QUEUE, true);
    }
}
