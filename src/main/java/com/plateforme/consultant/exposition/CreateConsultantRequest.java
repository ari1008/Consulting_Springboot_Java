package com.plateforme.consultant.exposition;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class CreateConsultantRequest {



    @NotNull
    public final String firstName;
    @NotNull
    public final  String lastName;
    @NotNull
    public final String modality;
    @NotNull
    public final Date startDate;
    @NotNull
    public final Date endDate;
    @NotNull
    public final Double tjm;

    public CreateConsultantRequest(String firstName, String lastName, String modality, Date startDate, Date endDate, Double tjm) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.modality = modality;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tjm = tjm;
    }
}
