package io.github.joaodurante.cardms.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

@Data
public class CardIssuanceData {
    private Long idCard;
    private String cpf;
    private String address;
    private Long approvedLimit;

    public static CardIssuanceData fromJson(String jsonData) throws JsonProcessingException {
        var mapper = new ObjectMapper();
        return mapper.readValue(jsonData, CardIssuanceData.class);
    }
}