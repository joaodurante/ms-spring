package io.github.com.creditappraisalms.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerCard {
    private String name;
    private String flag;
    private Long approvedLimit;
}
