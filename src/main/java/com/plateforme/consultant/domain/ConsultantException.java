package com.plateforme.consultant.domain;

public class ConsultantException extends RuntimeException {

    private ConsultantException(String message) {
        super(message);
    }

    public static ConsultantException notFoundAccountId(ConsultantId consultantIdId) {
        return new ConsultantException(String.format("%s not found.", consultantIdId.value()));
    }

}
