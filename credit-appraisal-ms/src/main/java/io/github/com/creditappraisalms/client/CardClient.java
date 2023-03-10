package io.github.com.creditappraisalms.client;

import io.github.com.creditappraisalms.domain.Card;
import io.github.com.creditappraisalms.domain.CustomerCard;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "${ms.card.name}", path = "${ms.card.path}")
public interface CardClient {
    @GetMapping(value = "/findCardsByCpf", params = {"cpf"})
    ResponseEntity<List<CustomerCard>> findCardsByCpf(@RequestParam("cpf") String cpf);

    @GetMapping(value = "/findByIncomeLessThanEqual", params = {"income"})
    ResponseEntity<List<Card>> findCardsByIncome(@RequestParam("income") Long income);
}
