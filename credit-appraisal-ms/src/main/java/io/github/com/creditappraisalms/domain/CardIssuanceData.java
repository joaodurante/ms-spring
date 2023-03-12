package io.github.com.creditappraisalms.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

@Data
public class CardIssuanceData {
    private Long idCard;
    private String cpf;
    private String address;
    private Long approvedLimit;

    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }
}
