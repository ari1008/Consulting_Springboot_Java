package com.plateforme.consulting.application.port.in;

import com.plateforme.consulting.application.port.out.CreateConsultantPort;
import com.plateforme.consulting.application.services.CreateConsultantService;
import com.plateforme.validation.Command;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;


public class CreateConsultant implements Command<CreateConsultant> {
    @NotNull
    public final  String name;

    public final String lastName;

    public final String nickName;

    public final int age;

    public final String password;




    public CreateConsultant(String name, String lastName, String nickName, int age, String password) {
        this.name = name;
        this.lastName = lastName;
        this.nickName = nickName;
        this.age = age;
        this.password = password;
        validate(this);
        System.out.println("hello");
    }
}
