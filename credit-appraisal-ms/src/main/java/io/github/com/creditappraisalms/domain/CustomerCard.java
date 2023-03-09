package io.github.com.creditappraisalms.domain;

import lombok.Data;

@Data
public class CustomerCard {
    private String name;
    private String flag;
    private Long approvedLimit;
}
