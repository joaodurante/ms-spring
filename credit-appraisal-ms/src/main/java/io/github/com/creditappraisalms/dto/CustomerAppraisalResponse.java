package io.github.com.creditappraisalms.dto;

import io.github.com.creditappraisalms.domain.CustomerCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAppraisalResponse {
    private List<CustomerCard> cards;
}
