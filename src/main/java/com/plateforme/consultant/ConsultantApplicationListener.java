package com.plateforme.consultant;

import com.plateforme.consultant.application.CreateConsultantCommand;
import com.plateforme.consultant.application.events.ConsultantCreatedApplicationEvent;
import com.plateforme.consultant.application.events.ConsultantCreatedEventHandler;
import com.plateforme.consultant.application.service.CreateConsultantService;
import com.plateforme.consultant.domain.Consultant;
import com.plateforme.consultant.domain.ConsultantId;
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



    private final ConsultantCreatedEventHandler consultantCreatedEventHandler;

    public ConsultantApplicationListener(CommandBus commandBus, QueryBus queryBus, EventDispatcher eventDispatcher, CreateConsultantService createConsultantService, ConsultantCreatedEventHandler consultantCreatedEventHandler) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
        this.eventDispatcher = eventDispatcher;
        this.createConsultantService = createConsultantService;
        this.consultantCreatedEventHandler = consultantCreatedEventHandler;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        eventDispatcher.register(ConsultantCreatedApplicationEvent.class, consultantCreatedEventHandler);
        commandBus.register(CreateConsultantCommand.class, createConsultantService);

    }
}
