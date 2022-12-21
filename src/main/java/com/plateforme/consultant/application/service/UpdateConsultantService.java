package com.plateforme.consultant.application.service;
import com.plateforme.consultant.application.UpdateConsultantCommand;
import com.plateforme.consultant.application.events.ConsultantUpdateApplicationEvent;
import com.plateforme.consultant.domain.Consultant;
import com.plateforme.consultant.domain.ConsultantId;
import com.plateforme.consultant.domain.Consultants;
import com.plateforme.kernel.CommandHandler;
import com.plateforme.kernel.Event;
import com.plateforme.kernel.EventDispatcher;



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
        var dateStart = command.getStartDate() != null ? command.getStartDate() : consultant.getStartDate();
        var dateEnd = command.getEndDate() != null ? command.getEndDate() : consultant.getEndDate();
        var modality = command.getModality() != null ? command.getModality() : consultant.getModality();
        var tjm = command.getTjm() != null ? command.getTjm() : consultant.getTjm();
        return  new Consultant(consultantId,
                firstName, lastName, modality, dateStart, dateEnd, tjm);
    }
}
