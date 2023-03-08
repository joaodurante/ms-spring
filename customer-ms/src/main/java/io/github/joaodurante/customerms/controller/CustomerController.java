package io.github.joaodurante.customerms.controller;

import io.github.joaodurante.customerms.domain.Customer;
import io.github.joaodurante.customerms.dto.CustomerSaveRequest;
import io.github.joaodurante.customerms.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.text.ParseException;
import java.util.Optional;

@RestController
@RequestMapping("customer")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/health-check")
    public String healthCheck() {
        log.info("Health-check - OK");
        return "OK";
    }

    @GetMapping(params = {"cpf"})
    public ResponseEntity<Customer> getCustomer(@RequestParam("cpf") String cpf) {
        Optional<Customer> customer = customerService.getByCpf(cpf);
        if(customer.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customer.get());
    }

    @PostMapping
    public ResponseEntity saveCustomer(@RequestBody CustomerSaveRequest customer) throws ParseException {
        customerService.save(customer.toModel());
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={query}")
                .buildAndExpand(customer.getCpf())
                .toUri();

        return ResponseEntity.created(headerLocation).build();
    }
}
