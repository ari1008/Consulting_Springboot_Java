package com.plateforme.consultant.application.service;
import com.plateforme.consultant.application.UpdateConsultantCommand;
import com.plateforme.consultant.application.events.ConsultantUpdateApplicationEvent;
import com.plateforme.consultant.domain.*;
import com.plateforme.kernel.CommandHandler;
import com.plateforme.kernel.Event;
import com.plateforme.kernel.EventDispatcher;

import java.util.ArrayList;
import java.util.List;


public class UpdateConsultantService implements CommandHandler<UpdateConsultantCommand, Consultant> {

    private final Consultants consultants;

    private final EventDispatcher<? super Event> eventDispatcher;

    public UpdateConsultantService(Consultants consultants, EventDispatcher<? super Event> eventDispatcher) {
        this.eventDispatcher = eventDispatcher;
        this.consultants =consultants;
    }

    @Override
    public Consultant handle(UpdateConsultantCommand command) {
        var consultantId  = ConsultantId.of(command.getId());
        var consultantEntity = consultants.findById(consultantId);
        System.out.println(consultantEntity.getRecordedEvents().toString());
        var  result = create(consultantId, command, consultantEntity);
         consultants.update(result);
        eventDispatcher.dispatch(new ConsultantUpdateApplicationEvent(
                result.getConsultantId(), result.getFirstName(), result.getLastName(), result.getModality(),
                result.getStartDate(), result.getEndDate(), result.getTjm()
        ));
        return result;
    }

    private Consultant create(ConsultantId consultantId, UpdateConsultantCommand command, Consultant consultant){
        var firstName = command.getFirstName() != null ? command.getFirstName() : consultant.getFirstName();
        var lastName = command.getLastName() != null ? command.getLastName() : consultant.getLastName();
        var startDate = command.getStartDate() != null ? command.getStartDate() : consultant.getStartDate();
        var endDate = command.getEndDate() != null ? command.getEndDate() : consultant.getEndDate();
        if (startDate.after(endDate)) throw  ConsultantException.beginDateStartAfterDateEnd(startDate,endDate);
        var modality = command.getModality() != null ? command.getModality() : consultant.getModality();
        var tjm = command.getTjm() != null ? command.getTjm() : consultant.getTjm();
        List<Event> eventRecorded = new ArrayList<>();
        eventRecorded.add(new ConsultantUpdated(
                consultantId, firstName, lastName, modality, startDate, endDate, tjm
        ));
        consultant.getRecordedEvents().stream().forEach(event -> eventRecorded.add(event));
        return  new Consultant(consultantId,
                firstName, lastName, modality, startDate, endDate, tjm, eventRecorded);
    }
}
