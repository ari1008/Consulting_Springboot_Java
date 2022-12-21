package com.plateforme.consultant.application.service;

import com.plateforme.consultant.application.SearchConsultantCommand;
import com.plateforme.consultant.domain.Consultant;
import com.plateforme.consultant.domain.Consultants;
import com.plateforme.kernel.CommandHandler;
import com.plateforme.kernel.Event;
import com.plateforme.kernel.EventDispatcher;

import javax.validation.constraints.NotNull;
import java.util.List;

public class SearchConsultantService  implements CommandHandler<SearchConsultantCommand, List<Consultant>> {


    private final Consultants consultants;

    private final EventDispatcher<? super Event> eventDispatcher;

    @Override
    public List<Consultant> handle(SearchConsultantCommand command) {
        var result = consultants.search(command.getPage(), command.getSize(),
                command.getFilterAnd(), command.getFilterOr(), command.getOrders());
        return result;
    }

    public SearchConsultantService(Consultants consultants, EventDispatcher<? super Event> eventDispatcher) {
        this.consultants = consultants;
        this.eventDispatcher = eventDispatcher;
    }



}
