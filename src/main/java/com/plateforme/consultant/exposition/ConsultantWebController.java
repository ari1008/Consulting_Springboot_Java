package com.plateforme.consultant.exposition;


import com.plateforme.consultant.application.CreateConsultantCommand;
import com.plateforme.consultant.application.UpdateConsultantCommand;
import com.plateforme.consultant.domain.Consultant;
import com.plateforme.kernel.Command;
import com.plateforme.kernel.CommandBus;
import com.plateforme.kernel.QueryBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

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
        var consultantId = (String) commandBus.post( new CreateConsultantCommand(
                createConsultantRequest.firstName,
                createConsultantRequest.lastName,
                createConsultantRequest.modality,
                createConsultantRequest.startDate,
                createConsultantRequest.endDate,
                createConsultantRequest.tjm
        ));
        return new CreateConsultantResponse(consultantId);
    }


    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ModifyConsultantResponse modify(@RequestBody @Valid ModifyConsultantRequest modifyConsultantRequest){
        var consultant =  commandBus.post(new UpdateConsultantCommand(
                UUID.fromString(modifyConsultantRequest.id), modifyConsultantRequest.firstName,
                        modifyConsultantRequest.lastName, modifyConsultantRequest.modality,
                modifyConsultantRequest.startDate, modifyConsultantRequest.endDate, modifyConsultantRequest.tjm));
        System.out.println(consultant.toString());
         /*return new ModifyConsultantResponse(consultant.getConsultantId().value(), consultant.getFirstName(), consultant.getLastName(),
                 consultant.getModality(), consultant.getStartDate(), consultant.getEndDate(),consultant.getTjm())   ;*/
        return  null;
    }





}
