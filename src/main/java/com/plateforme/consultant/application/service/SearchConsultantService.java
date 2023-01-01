package com.plateforme.consultant.application.service;

import com.plateforme.consultant.application.SearchConsultantCommand;
import com.plateforme.consultant.application.events.ConsultantSearchApplicationEvent;
import com.plateforme.consultant.domain.Consultant;
import com.plateforme.consultant.domain.ConsultantId;
import com.plateforme.consultant.domain.ConsultantSearched;
import com.plateforme.consultant.domain.Consultants;
import com.plateforme.consultant.exposition.ModifyConsultantResponse;
import com.plateforme.consultant.infrastructure.ConsultantEntity;
import com.plateforme.kernel.CommandHandler;
import com.plateforme.kernel.Event;
import com.plateforme.kernel.EventDispatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class SearchConsultantService  implements CommandHandler<SearchConsultantCommand, List<ModifyConsultantResponse>> {


    private final Consultants consultants;

    private final EventDispatcher<? super Event> eventDispatcher;

    @Override
    public List<ModifyConsultantResponse> handle(SearchConsultantCommand command) throws Exception {
        var result = consultants.search(command.getPage(), command.getSize(),
                command.getFilterAnd(), command.getFilterOr(), command.getOrders());
        var listUpdate  = result.stream().map(consultant -> addEventConsultant(consultant, command )).toList();
        consultants.saveAll(listUpdate);
        eventDispatcher.dispatch(
                new ConsultantSearchApplicationEvent(command.getPage(), command.getSize(), command.getFilterOr(),
                        command.getFilterAnd(), command.getOrders())
        );
        return result.stream().map(this::createConsultanteResponse).collect(Collectors.toList());
    }

    public SearchConsultantService(Consultants consultants, EventDispatcher<? super Event> eventDispatcher) {
        this.consultants = consultants;
        this.eventDispatcher = eventDispatcher;
    }

    public ModifyConsultantResponse createConsultanteResponse(Consultant consultant){
        return new ModifyConsultantResponse(
                consultant.getConsultantId().value(),
                consultant.getFirstName(),
                consultant.getLastName(),
                consultant.getModality(),
                consultant.getStartDate(),
                consultant.getEndDate(),
                consultant.getTjm()
        );
    }

    private Consultant addEventConsultant(Consultant consultant, SearchConsultantCommand command ){
        List<Event> event = new ArrayList<>(consultant.getRecordedEvents());
        event.add(new ConsultantSearched(command.getPage(), command.getSize(), command.getFilterOr(), command.getFilterAnd(), command.getOrders()));
        consultant.setRecordedEvents(event);
        return consultant;
    }



}
