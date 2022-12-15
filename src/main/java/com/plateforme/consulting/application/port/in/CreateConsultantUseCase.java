package com.plateforme.consulting.application.port.in;

import com.plateforme.consulting.application.port.out.CreateConsultantPort;
import com.plateforme.consulting.domain.ConsultantId;

public interface CreateConsultantUseCase {

    ConsultantId createConsultant(CreateConsultant  createConsultant);

}
