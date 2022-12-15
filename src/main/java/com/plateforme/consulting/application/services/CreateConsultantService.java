package com.plateforme.consulting.application.services;

import com.plateforme.consulting.application.port.in.CreateConsultant;
import com.plateforme.consulting.application.port.in.CreateConsultantUseCase;
import com.plateforme.consulting.application.port.out.CreateConsultantPort;
import com.plateforme.consulting.domain.Consultant;
import com.plateforme.consulting.domain.ConsultantId;

public class CreateConsultantService implements CreateConsultantUseCase {

    private final CreateConsultantPort createConsultantPort;

    public CreateConsultantService(CreateConsultantPort createConsultantPort){this.createConsultantPort = createConsultantPort;}
    @Override
    public ConsultantId createConsultant(CreateConsultant createConsultant) {
        var consultantId = createConsultantPort.nexId();
        var consultant = new Consultant(consultantId, createConsultant.name, createConsultant.lastName,
                createConsultant.nickName, createConsultant.age, createConsultant.password);
        createConsultantPort.save(consultant);
        return consultantId;

    }
}
