package com.plateforme.consultant.domain;

import com.plateforme.kernel.Event;

import java.util.*;

public class Consultant {

    private final  ConsultantId consultantId;
    private final String firstName;

    private final  String lastName;

    private final String modality;

    private final Date startDate;

    private final Date endDate;

    private final Double tjm;



    private List<Event> recordedEvents;


    public Consultant(ConsultantId consultantId, String firstName, String lastName, String modality, Date startDate, Date endDate, Double tjm, List<Event> recordedEvents) {
        this.consultantId = consultantId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.modality = modality;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tjm = tjm;
        this.recordedEvents = recordedEvents;
    }

    public Consultant(ConsultantId consultantId, String firstName, String lastName, String modality, Date startDate, Date endDate, Double tjm) {
        this.consultantId = consultantId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.modality = modality;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tjm = tjm;
        this.recordedEvents = new ArrayList<>();
        this.recordedEvents.add(new ConsultantCreated(consultantId, firstName, lastName, modality, startDate, endDate, tjm));

    }

    public List<Event> getRecordedEvents() {
        return Collections.unmodifiableList(recordedEvents);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consultant consultant = (Consultant) o;
        return Objects.equals(consultantId, consultant.consultantId);
    }
}
