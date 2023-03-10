package io.github.joaodurante.customerms.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private String name;
    private LocalDate dateOfBirth;

    public Customer(String cpf, String name, LocalDate dateOfBirth) {
        this.cpf = cpf;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }
}
