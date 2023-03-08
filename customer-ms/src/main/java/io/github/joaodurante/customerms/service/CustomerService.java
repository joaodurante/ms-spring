package io.github.joaodurante.customerms.service;

import io.github.joaodurante.customerms.domain.Customer;
import io.github.joaodurante.customerms.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Transactional
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public Optional<Customer> getByCpf(String cpf) {
        return customerRepository.findByCpf(cpf);
    }
}
