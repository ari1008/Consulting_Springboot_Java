package com.plateforme.consultant.exposition;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class ModifyConsultantRequest {

    @NotNull
    public String id;


    public String firstName;

    public String lastName;

    public String modality;


    public Date startDate;

    public Date endDate;

    public Double tjm;

    public ModifyConsultantRequest(@JsonProperty("fistName") String firstName,
                                   @JsonProperty("lastName") String lastName,
                                   @JsonProperty("modality") String modality,
                                   @JsonProperty("startDate") Date startDate,
                                   @JsonProperty("endDate") Date endDate,
                                   @JsonProperty("tjm") Double tjm) {
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

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setModality(String modality) {
        this.modality = modality;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setTjm(Double tjm) {
        this.tjm = tjm;
    }
}
