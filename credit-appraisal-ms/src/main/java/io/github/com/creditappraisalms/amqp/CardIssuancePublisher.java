package io.github.com.creditappraisalms.amqp;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.com.creditappraisalms.domain.CardIssuanceData;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CardIssuancePublisher {
    private final RabbitTemplate rabbitTemplate;

    private final Queue cardIssuanceQueue;

    public void requestCardIssuance(CardIssuanceData data) throws JsonProcessingException {
        rabbitTemplate.convertAndSend(cardIssuanceQueue.getName(), data.toJson());
    }
}
