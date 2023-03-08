package io.github.joaodurante.cardms.dto;

import io.github.joaodurante.cardms.domain.Card;
import io.github.joaodurante.cardms.domain.CardFlag;
import lombok.Data;

@Data
public class CardSaveRequest {
    private String name;
    private CardFlag flag;
    private Long income;
    private Long preApprovedLimit;

    public Card toModel() {
        return new Card(name, flag, income, preApprovedLimit);
    }
}
