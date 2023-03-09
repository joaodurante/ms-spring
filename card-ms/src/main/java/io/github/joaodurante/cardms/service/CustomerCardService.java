package io.github.joaodurante.cardms.service;


import io.github.joaodurante.cardms.domain.CustomerCard;
import io.github.joaodurante.cardms.repository.CustomerCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerCardService {
    private final CustomerCardRepository customerCardRepository;

    public List<CustomerCard> findCardsByCpf(String cpf) {
        return customerCardRepository.findByCpf(cpf);
    }
}
