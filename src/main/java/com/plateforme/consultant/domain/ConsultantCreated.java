package com.plateforme.consultant.domain;

import com.plateforme.kernel.Event;

public class ConsultantCreated  implements Event {

    private final ConsultantId consultantId;

    private final  String name;

    private final String password;

    public ConsultantCreated(ConsultantId consultantId, String name, String password) {
        this.consultantId = consultantId;
        this.name = name;
        this.password = password;
    }


    public ConsultantId getConsultantId(){return consultantId;}

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
