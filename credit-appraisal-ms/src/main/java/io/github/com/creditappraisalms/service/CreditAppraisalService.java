package io.github.com.creditappraisalms.service;

import feign.FeignException;
import io.github.com.creditappraisalms.client.CardClient;
import io.github.com.creditappraisalms.client.CustomerClient;
import io.github.com.creditappraisalms.domain.*;
import io.github.com.creditappraisalms.dto.CustomerAppraisalResponse;
import io.github.com.creditappraisalms.dto.CustomerStatus;
import io.github.com.creditappraisalms.ex.CustomerDataNotFoundException;
import io.github.com.creditappraisalms.ex.MsCommunicationException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CreditAppraisalService {
    private final CustomerClient customerClient;
    private final CardClient cardClient;

    public CustomerStatus checkCustomerStatus(String cpf) throws CustomerDataNotFoundException, MsCommunicationException {
        try {
            ResponseEntity<CustomerData> customer = customerClient.getCustomer(cpf);
            ResponseEntity<List<CustomerCard>> cards = cardClient.findCardsByCpf(cpf);
            return CustomerStatus
                    .builder()
                    .customer(customer.getBody())
                    .customerCards(cards.getBody())
                    .build();
        } catch(FeignException.FeignClientException e) {
            int status = e.status();
            if(status == HttpStatus.NOT_FOUND.value()) {
                throw new CustomerDataNotFoundException();
            }
            throw new MsCommunicationException(status, e.contentUTF8());
        }
    }

    public CustomerAppraisalResponse appraiseCustomerCredit(String cpf, Long income) throws CustomerDataNotFoundException, MsCommunicationException {
        try {
            ResponseEntity<CustomerData> customer = customerClient.getCustomer(cpf);
            ResponseEntity<List<Card>> cards = cardClient.findCardsByIncome(income);

            List<CustomerCard> approvedCustomerCards = cards.getBody().stream().map(card -> {
                Integer age = calculateAge(customer.getBody().getDateOfBirth());
                Long approvedLimit = (long) (card.getPreApprovedLimit() * (age * 0.1));

                return new CustomerCard(card.getName(), card.getFlag(), approvedLimit);
            }).collect(Collectors.toList());

            return new CustomerAppraisalResponse(approvedCustomerCards);

        } catch(FeignException.FeignClientException e) {
            int status = e.status();
            if(status == HttpStatus.NOT_FOUND.value()) {
                throw new CustomerDataNotFoundException();
            }
            throw new MsCommunicationException(status, e.contentUTF8());
        }
    }

    private Integer calculateAge(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }
}
