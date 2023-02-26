package com.plateforme.consultant.application.events;

import com.plateforme.consultant.domain.Consultant;
import com.plateforme.consultant.domain.ConsultantId;
import com.plateforme.kernel.Event;

import java.util.Date;

public class ConsultantCreatedApplicationEvent implements Event {

    private final ConsultantId consultantId;
    private final String firstName;

    private final String lastName;

    private final String modality;

    private final Date startDate;

    private final Date endDate;

    private final Double tjm;

    public ConsultantCreatedApplicationEvent(ConsultantId consultantId, String firstName,
                                             String lastName, String modality, Date startDate, Date endDate, Double tjm) {
        this.consultantId = consultantId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.modality = modality;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tjm = tjm;
    }

    public ConsultantId getConsultantId() {
        return consultantId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getModality() {
        return modality;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Double getTjm() {
        return tjm;
    }
}
