package com.plateforme.consultant.exposition;

import javax.validation.constraints.NotNull;

public class CreateConsultantRequest {



    @NotNull
    public String name;

    @NotNull
    public String password;
}
