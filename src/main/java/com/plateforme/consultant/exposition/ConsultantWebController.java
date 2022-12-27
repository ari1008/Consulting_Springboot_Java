package com.plateforme.consultant.exposition;


import com.plateforme.consultant.application.CreateConsultantCommand;
import com.plateforme.consultant.application.SearchConsultantCommand;
import com.plateforme.consultant.application.UpdateConsultantCommand;
import com.plateforme.consultant.domain.Consultant;
import com.plateforme.kernel.Command;
import com.plateforme.kernel.CommandBus;
import com.plateforme.kernel.QueryBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/consultants")
public class ConsultantWebController {

    private final CommandBus<Command> commandBus;
    private final QueryBus<com.plateforme.kernel.Query> queryBus;

    @Autowired
    private ConsultantWebController(CommandBus<Command> commandBus, QueryBus<com.plateforme.kernel.Query> queryBus) {
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
        var consultant = (Consultant) commandBus.post(new UpdateConsultantCommand(
                UUID.fromString(modifyConsultantRequest.id), modifyConsultantRequest.firstName,
                        modifyConsultantRequest.lastName, modifyConsultantRequest.modality,
                modifyConsultantRequest.startDate, modifyConsultantRequest.endDate, modifyConsultantRequest.tjm));

         return new ModifyConsultantResponse(consultant.getConsultantId().value(), consultant.getFirstName(), consultant.getLastName(),
                 consultant.getModality(), consultant.getStartDate(), consultant.getEndDate(),consultant.getTjm())   ;
    }

    @PostMapping( value = "/search", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public SearchConsultantResponse searchConsultant(@RequestBody @Valid SearchConsultantRequest searchConsultantRequest){
        var searchListConsultantsResult = (List<ModifyConsultantResponse>) commandBus.post(new SearchConsultantCommand(
                searchConsultantRequest.getPage(),  searchConsultantRequest.getSize(), searchConsultantRequest.getFilterOr(),
                searchConsultantRequest.getFilterAnd(), searchConsultantRequest.getOrders()
        ));
        return new SearchConsultantResponse(searchConsultantRequest.getPage(), searchConsultantRequest.getSize(),
                searchConsultantRequest.getFilterOr(),
                searchConsultantRequest.getFilterAnd(), searchConsultantRequest.getOrders(), searchListConsultantsResult);

    }





}
