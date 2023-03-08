package io.github.joaodurante.customerms.dto;

import io.github.joaodurante.customerms.domain.Customer;
import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Data
public class CustomerSaveRequest {
    private String cpf;
    private String name;
    private String dateOfBirth;

    public Customer toModel() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return new Customer(
                cpf,
                name,
                dateFormat.parse(dateOfBirth)
        );
    }
}
