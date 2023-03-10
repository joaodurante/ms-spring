package io.github.com.creditappraisalms.domain;

import lombok.Data;

@Data
public class Card {
    private Long id;
    private String name;
    private String flag;
    private Long preApprovedLimit;
}
