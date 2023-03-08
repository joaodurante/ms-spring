package io.github.joaodurante.cardms.repository;

import io.github.joaodurante.cardms.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {

    List<Card> findByIncomeLessThanEqual(Long income);
}
