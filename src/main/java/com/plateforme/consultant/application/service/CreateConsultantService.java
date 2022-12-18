package com.plateforme.consultant.application.service;

import com.plateforme.consultant.application.CreateConsultantCommand;
import com.plateforme.consultant.application.events.ConsultantCreatedApplicationEvent;
import com.plateforme.consultant.application.events.ConsultantCreatedEventHandler;
import com.plateforme.consultant.domain.Consultant;
import com.plateforme.consultant.domain.Consultants;
import com.plateforme.kernel.Command;
import com.plateforme.kernel.CommandHandler;
import com.plateforme.kernel.Event;
import com.plateforme.kernel.EventDispatcher;

public class CreateConsultantService implements CommandHandler<CreateConsultantCommand, String> {

    private final Consultants consultants;

    private final EventDispatcher<? super Event> eventDispatcher;

    public CreateConsultantService(Consultants consultants, EventDispatcher<? super Event> eventDispatcher) {
        this.consultants = consultants;
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public String handle(CreateConsultantCommand command) {
        var consultantId = consultants.nextId();
        System.out.println(consultantId.value());
        var consultant = new Consultant(command.name, command.password, consultantId);
        consultants.add(consultant);
        eventDispatcher.dispatch(new ConsultantCreatedApplicationEvent(consultant.getConsultantId()
                , consultant.getName(), consultant.getPassword()));
        return consultantId.value();

    }


}
