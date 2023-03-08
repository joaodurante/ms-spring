package io.github.joaodurante.cardms.controller;

import io.github.joaodurante.cardms.domain.Card;
import io.github.joaodurante.cardms.dto.CardSaveRequest;
import io.github.joaodurante.cardms.service.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("card")
@RequiredArgsConstructor
@Slf4j
public class CardController {
    private final CardService cardService;

    @GetMapping("/health-check")
    public String healthCheck() {
        log.info("Health-check - OK");
        return "OK";
    }

    @GetMapping(value = "/findByIncomeLessThanEqual", params = {"income"})
    public ResponseEntity<List<Card>> findCardsByIncome(@RequestParam("income") Long income) {
        List<Card> cardList = cardService.findCardsByIncome(income);
        return ResponseEntity.ok(cardList);
    }

    @PostMapping()
    public ResponseEntity save(@RequestBody CardSaveRequest card) {
        cardService.save(card.toModel());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
