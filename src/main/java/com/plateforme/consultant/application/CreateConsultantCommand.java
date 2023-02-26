package com.plateforme.consultant.application;

import com.plateforme.kernel.Command;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class CreateConsultantCommand implements Command {


    @NotNull
    private final String firstName;
    @NotNull
    private final String lastName;
    @NotNull
    private final String modality;
    @NotNull
    private final Date startDate;
    @NotNull
    private final Date endDate;
    @NotNull
    private final Double tjm;

    public CreateConsultantCommand(String firstName, String lastName, String modality, Date startDate, Date endDate, Double tjm) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.modality = modality;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tjm = tjm;
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
