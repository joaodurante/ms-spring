package io.github.com.creditappraisalms.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerData {
    private Long id;
    private String name;
    private LocalDate dateOfBirth;
}
