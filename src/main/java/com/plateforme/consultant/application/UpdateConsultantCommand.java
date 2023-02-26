package com.plateforme.consultant.application;

import com.plateforme.kernel.Command;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

public class UpdateConsultantCommand implements Command {

    @NotNull
    private final String id;

    private final String firstName;

    private final String lastName;

    private final String modality;

    private final Date startDate;


    private final Date endDate;

    private final Double tjm;


    public UpdateConsultantCommand(String id, String firstName, String lastName, String modality, Date startDate, Date endDate, Double tjm) {
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
