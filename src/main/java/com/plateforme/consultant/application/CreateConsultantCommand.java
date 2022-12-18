package com.plateforme.consultant.application;

import com.plateforme.kernel.Command;

import javax.validation.constraints.NotNull;

public class CreateConsultantCommand implements Command {

    @NotNull
    public final String name;

    @NotNull
    public final  String password;

    public CreateConsultantCommand(String name, String password) {
        this.name = name;
        this.password = password;

    }
}
