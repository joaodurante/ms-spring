package io.github.joaodurante.cardms.controller;

import io.github.joaodurante.cardms.domain.Card;
import io.github.joaodurante.cardms.domain.CustomerCard;
import io.github.joaodurante.cardms.dto.CardSaveRequest;
import io.github.joaodurante.cardms.dto.CustomerCardResponse;
import io.github.joaodurante.cardms.service.CardService;
import io.github.joaodurante.cardms.service.CustomerCardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("card")
@RequiredArgsConstructor
@Slf4j
public class CardController {
    private final CardService cardService;
    private final CustomerCardService customerCardService;

    @GetMapping("/health-check")
    public String healthCheck() {
        log.info("Health-check - OK");
        return "OK";
    }

    @GetMapping(value = "/find-by-income-less-than-equal", params = {"income"})
    public ResponseEntity<List<Card>> findCardsByIncome(@RequestParam("income") Long income) {
        List<Card> cardList = cardService.findCardsByIncome(income);
        return ResponseEntity.ok(cardList);
    }

    @PostMapping()
    public ResponseEntity save(@RequestBody CardSaveRequest card) {
        cardService.save(card.toModel());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/find-cards-by-cpf", params = {"cpf"})
    public ResponseEntity<List<CustomerCardResponse>> findCardsByCpf(@RequestParam("cpf") String cpf) {
        List<CustomerCard> cards = customerCardService.findCardsByCpf(cpf);
        List<CustomerCardResponse> response = cards.stream()
                .map(CustomerCardResponse::fromModel)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }
}
