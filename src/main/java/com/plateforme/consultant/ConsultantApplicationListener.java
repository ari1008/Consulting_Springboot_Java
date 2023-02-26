package com.plateforme.consultant;

import com.plateforme.consultant.application.CreateConsultantCommand;
import com.plateforme.consultant.application.SearchConsultantCommand;
import com.plateforme.consultant.application.UpdateConsultantCommand;
import com.plateforme.consultant.application.events.*;
import com.plateforme.consultant.application.service.CreateConsultantService;
import com.plateforme.consultant.application.service.SearchConsultantService;
import com.plateforme.consultant.application.service.UpdateConsultantService;
import com.plateforme.kernel.CommandBus;
import com.plateforme.kernel.EventDispatcher;
import com.plateforme.kernel.QueryBus;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
@SuppressWarnings("all")
public class ConsultantApplicationListener implements ApplicationListener<ContextRefreshedEvent> {


    private final CommandBus commandBus;
    private final QueryBus queryBus;

    private final EventDispatcher eventDispatcher;

    private final CreateConsultantService createConsultantService;

    private final UpdateConsultantService updateConsultantService;

    private final SearchConsultantService searchConsultantService;


    private final ConsultantCreatedEventHandler consultantCreatedEventHandler;

    private final ConsultantUpdateEventHandler consultantUpdateEventHandler;

    private final ConsultantSearchEventHandler consultantSearchEventHandler;

    public ConsultantApplicationListener(CommandBus commandBus, QueryBus queryBus, EventDispatcher eventDispatcher, CreateConsultantService createConsultantService, UpdateConsultantService updateConsultantService, SearchConsultantService searchConsultantService, ConsultantCreatedEventHandler consultantCreatedEventHandler, ConsultantUpdateEventHandler consultantUpdateEventHandler, ConsultantSearchEventHandler consultantSearchEventHandler) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
        this.eventDispatcher = eventDispatcher;
        this.createConsultantService = createConsultantService;
        this.updateConsultantService = updateConsultantService;
        this.searchConsultantService = searchConsultantService;
        this.consultantCreatedEventHandler = consultantCreatedEventHandler;
        this.consultantUpdateEventHandler = consultantUpdateEventHandler;
        this.consultantSearchEventHandler = consultantSearchEventHandler;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        eventDispatcher.register(ConsultantCreatedApplicationEvent.class, consultantCreatedEventHandler);
        eventDispatcher.register(ConsultantUpdateApplicationEvent.class, consultantUpdateEventHandler);
        eventDispatcher.register(ConsultantSearchApplicationEvent.class, consultantSearchEventHandler);
        commandBus.register(CreateConsultantCommand.class, createConsultantService);
        commandBus.register(UpdateConsultantCommand.class, updateConsultantService);
        commandBus.register(SearchConsultantCommand.class, searchConsultantService);

    }
}
