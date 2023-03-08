package io.github.joaodurante.cardms.service;

import io.github.joaodurante.cardms.domain.Card;
import io.github.joaodurante.cardms.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;

    @Transactional
    public Card save(Card card) {
        return cardRepository.save(card);
    }

    public List<Card> findCardsByIncome(Long income) {
        return cardRepository.findByIncomeLessThanEqual(income);
    }
}
