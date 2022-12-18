package com.plateforme.consultant.application.events;

import com.plateforme.consultant.domain.Consultant;
import com.plateforme.consultant.domain.ConsultantId;
import com.plateforme.kernel.Event;

public class ConsultantCreatedApplicationEvent implements Event {

    private  final ConsultantId consultantId;

    private final String name;

    private final String password;

    public ConsultantCreatedApplicationEvent(ConsultantId consultantId, String name, String password) {
        this.consultantId = consultantId;
        this.name = name;
        this.password = password;
    }

    public ConsultantId getConsultantId(){return  consultantId;}

    public String getName(){return  name;}

    public String getPassword(){return password;}
}
