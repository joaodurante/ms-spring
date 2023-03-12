package io.github.joaodurante.cardms.amqp;

import io.github.joaodurante.cardms.domain.Card;
import io.github.joaodurante.cardms.domain.CardIssuanceData;
import io.github.joaodurante.cardms.domain.CustomerCard;
import io.github.joaodurante.cardms.repository.CardRepository;
import io.github.joaodurante.cardms.repository.CustomerCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CardIssuanceSubscriber {
    private final CardRepository cardRepository;
    private final CustomerCardRepository customerCardRepository;

    @RabbitListener(queues = "${mq.queues.card-issuance}")
    public void cardIssuanceListener(@Payload String payload) {
        try {
            CardIssuanceData cardIssuanceData = CardIssuanceData.fromJson(payload);
            Card card = cardRepository.getReferenceById(cardIssuanceData.getIdCard());
            CustomerCard customerCard = new CustomerCard(
                    cardIssuanceData.getCpf(),
                    card,
                    cardIssuanceData.getApprovedLimit()
            );

            customerCardRepository.save(customerCard);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
