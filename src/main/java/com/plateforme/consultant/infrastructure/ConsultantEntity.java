package com.plateforme.consultant.infrastructure;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Document(collection = "consultant")
public class ConsultantEntity {
    @MongoId
    private UUID id;
    private final String firstName;

    private final  String lastName;

    private final String modality;

    private final Date startDate;

    private final Date endDate;

    private final Double tjm;

    private List<EventEntity> recordedEvents;

    public ConsultantEntity(UUID id, String firstName, String lastName, String modality, Date startDate, Date endDate, Double tjm, List<EventEntity> recordedEvents) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.modality = modality;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tjm = tjm;
        this.recordedEvents = recordedEvents;
    }

    public UUID getId() {
        return id;
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

    public List<EventEntity> getRecordedEvents() {
        return recordedEvents;
    }




}
