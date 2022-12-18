package com.plateforme.consultant.domain;

import com.plateforme.kernel.Event;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Consultant {
    private final String name;
    private final String password;

    private final  ConsultantId consultantId;

    private List<Event> recordedEvents;

    public Consultant(String name, String password, ConsultantId consultantId){
        this.consultantId = consultantId;
        this.name = name;
        this.password = password;
        this.recordedEvents = new ArrayList<>();
        this.recordedEvents.add(new ConsultantCreated(consultantId, name, password));
    }

    public Consultant(String name, String password, ConsultantId consultantId,List<Event> events ){
        this.consultantId = consultantId;
        this.name = name;
        this.password = password;
        this.recordedEvents = events;
    }


    public List<Event> getRecordedEvents() {
        return Collections.unmodifiableList(recordedEvents);
    }

    public ConsultantId getConsultantId() {
        return consultantId;
    }

    public String getPassword(){return  password;}

    public String getName(){return  name;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consultant consultant = (Consultant) o;
        return Objects.equals(consultantId, consultant.consultantId);
    }
}
