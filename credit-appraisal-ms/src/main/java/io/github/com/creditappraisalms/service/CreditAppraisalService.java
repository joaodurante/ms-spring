package io.github.com.creditappraisalms.service;

import io.github.com.creditappraisalms.client.CardClient;
import io.github.com.creditappraisalms.client.CustomerClient;
import io.github.com.creditappraisalms.domain.CustomerCard;
import io.github.com.creditappraisalms.domain.CustomerData;
import io.github.com.creditappraisalms.domain.CustomerStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditAppraisalService {
    private final CustomerClient customerClient;
    private final CardClient cardClient;
    public CustomerStatus checkCustomerStatus(String cpf) {
        ResponseEntity<CustomerData> customer = customerClient.getCustomer(cpf);
        ResponseEntity<List<CustomerCard>> cards =cardClient.findCardsByCpf(cpf);
        return CustomerStatus
                .builder()
                .customer(customer.getBody())
                .cards(cards.getBody())
                .build();
    }
}
