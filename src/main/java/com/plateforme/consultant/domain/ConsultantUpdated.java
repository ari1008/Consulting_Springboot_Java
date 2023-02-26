package com.plateforme.consultant.domain;

import com.plateforme.kernel.Event;

import java.util.Date;

public class ConsultantUpdated implements Event {

    private final ConsultantId consultantId;
    private final String firstName;

    private final String lastName;

    private final String modality;

    private final Date startDate;

    private final Date endDate;

    private final Double tjm;

    public ConsultantUpdated(ConsultantId consultantId, String firstName, String lastName, String modality, Date startDate, Date endDate, Double tjm) {
        this.consultantId = consultantId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.modality = modality;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tjm = tjm;
    }
}
