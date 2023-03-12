package io.github.com.creditappraisalms.service;

import io.github.com.creditappraisalms.amqp.CardIssuancePublisher;
import io.github.com.creditappraisalms.domain.CardIssuanceData;
import io.github.com.creditappraisalms.domain.CardIssuanceProtocol;
import io.github.com.creditappraisalms.ex.CardIssuanceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardIssuanceService {
    private final CardIssuancePublisher cardIssuancePublisher;

    public CardIssuanceProtocol requestCardIssuance(CardIssuanceData data) {
        try {
            cardIssuancePublisher.requestCardIssuance(data);
            String protocol = UUID.randomUUID().toString();
            return new CardIssuanceProtocol(protocol);
        } catch (Exception e) {
            throw new CardIssuanceException(e.getMessage());
        }
    }
}
