package io.github.com.creditappraisalms.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerStatus {
    private CustomerData customer;
    private List<CustomerCard> cards;
}
