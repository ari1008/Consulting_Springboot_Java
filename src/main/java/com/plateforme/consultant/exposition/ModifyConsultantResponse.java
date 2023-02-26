package com.plateforme.consultant.exposition;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class ModifyConsultantResponse {

    @NotNull
    public final String id;

    @NotNull
    public final String firstName;
    @NotNull
    public final String lastName;
    @NotNull
    public final String modality;

    @NotNull
    public final Date startDate;
    @NotNull
    public final Date endDate;
    @NotNull
    public final Double tjm;

    public ModifyConsultantResponse(String id, String firstName, String lastName, String modality, Date startDate, Date endDate, Double tjm) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.modality = modality;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tjm = tjm;
    }

    public String getId() {
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
}
