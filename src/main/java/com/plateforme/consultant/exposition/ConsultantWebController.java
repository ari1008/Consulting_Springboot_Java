package com.plateforme.consultant.exposition;


import com.plateforme.consultant.application.CreateConsultantCommand;
import com.plateforme.kernel.Command;
import com.plateforme.kernel.CommandBus;
import com.plateforme.kernel.QueryBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/consultants")
public class ConsultantWebController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    @Autowired
    private ConsultantWebController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CreateConsultantResponse create(@RequestBody @Valid CreateConsultantRequest createConsultantRequest) {
        var consultantId = (String) commandBus.post( new CreateConsultantCommand(createConsultantRequest.name, createConsultantRequest.password ));
        return new CreateConsultantResponse(consultantId);
    }


}
