package io.github.com.creditappraisalms.dto;

import io.github.com.creditappraisalms.domain.CustomerCard;
import io.github.com.creditappraisalms.domain.CustomerData;
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
    private List<CustomerCard> customerCards;
}
