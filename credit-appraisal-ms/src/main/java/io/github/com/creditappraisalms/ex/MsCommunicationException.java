package io.github.com.creditappraisalms.ex;

import lombok.Getter;

public class MsCommunicationException extends Exception {
    @Getter
    private Integer status;
    public MsCommunicationException(Integer status, String message) {
        super(message);
        this.status = status;
    }
}
