package io.github.joaodurante.customerms.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private String name;
    private Date dateOfBirth;

    public Customer(String cpf, String name, Date dateOfBirth) {
        this.cpf = cpf;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }
}
