package io.github.joaodurante.cardms.dto;

import io.github.joaodurante.cardms.domain.Card;
import io.github.joaodurante.cardms.domain.CustomerCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCardResponse {
    private String name;
    private String flag;
    private Long approvedLimit;

    public static CustomerCardResponse fromModel(CustomerCard model) {
        Card card = model.getCard();
        return new CustomerCardResponse(card.getName(), card.getFlag().toString(), card.getPreApprovedLimit());
    }
}
