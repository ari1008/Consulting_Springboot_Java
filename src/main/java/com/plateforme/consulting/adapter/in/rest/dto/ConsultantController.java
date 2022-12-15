package com.plateforme.consulting.adapter.in.rest.dto;

import com.plateforme.consulting.adapter.in.rest.dto.ConsultantDto;
import com.plateforme.consulting.application.port.in.CreateConsultant;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class ConsultantController {


    @PostMapping("/consultant")
    ConsultantDto newConsultant(@RequestBody ConsultantDto consultant){
        System.out.println(consultant);
        CreateConsultant createConsultant = new CreateConsultant(
                consultant.name(),
                consultant.lastName(),
                consultant.nickname(),
                consultant.age(),
                consultant.password()
        );

        return  consultant;
    }




}
