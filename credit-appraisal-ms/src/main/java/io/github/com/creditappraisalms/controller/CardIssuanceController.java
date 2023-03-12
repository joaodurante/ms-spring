package io.github.com.creditappraisalms.controller;

import io.github.com.creditappraisalms.domain.CardIssuanceData;
import io.github.com.creditappraisalms.domain.CardIssuanceProtocol;
import io.github.com.creditappraisalms.ex.CardIssuanceException;
import io.github.com.creditappraisalms.service.CardIssuanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("card-issuance")
@RequiredArgsConstructor
public class CardIssuanceController {
    private final CardIssuanceService cardIssuanceService;

    @PostMapping("/request-card")
    public ResponseEntity requestCardIssuance(@RequestBody CardIssuanceData data) {
        try {
            CardIssuanceProtocol protocol = cardIssuanceService.requestCardIssuance(data);
            return ResponseEntity.ok(protocol);
        } catch(CardIssuanceException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
