package io.github.joaodurante.cardms.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Card {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private CardFlag flag;
    private Long income;
    private Long preApprovedLimit;

    public Card(String name, CardFlag flag, Long income, Long preApprovedLimit) {
        this.name = name;
        this.flag = flag;
        this.income = income;
        this.preApprovedLimit = preApprovedLimit;
    }
}
