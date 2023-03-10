package io.github.joaodurante.customerms.dto;

import io.github.joaodurante.customerms.domain.Customer;
import lombok.Data;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class CustomerSaveRequest {
    private String cpf;
    private String name;
    private String dateOfBirth;

    public Customer toModel() throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return new Customer(
                cpf,
                name,
                LocalDate.parse(dateOfBirth, formatter)
        );
    }
}
