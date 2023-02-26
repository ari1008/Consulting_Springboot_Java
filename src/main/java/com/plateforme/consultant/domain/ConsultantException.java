package com.plateforme.consultant.domain;

import java.util.Date;

public class ConsultantException extends RuntimeException {

    private ConsultantException(String message) {
        super(message);
    }

    public static ConsultantException notFoundAccountId(ConsultantId consultantIdId) {
        return new ConsultantException(String.format("%s not found.", consultantIdId.value()));
    }

    public static ConsultantException beginDateStartAfterDateEnd(Date startDate, Date endDate) {
        return new ConsultantException(String.format("date start %s > date end %s", startDate.toString(), endDate.toString()));
    }

}
