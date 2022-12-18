package com.plateforme.consultant.application.service;

import com.plateforme.consultant.domain.Consultant;
import com.plateforme.consultant.domain.ConsultantCreated;
import com.plateforme.consultant.domain.ConsultantId;
import com.plateforme.kernel.Event;

import java.util.List;

public class ConsultantReadModel {

    private  ConsultantId  consultantId;

    private  String name;
    private   String password;


    public  ConsultantReadModel(){
        /*this.consultantId = consultantId;
        this.name = name;
        this.password = password;*/
    }

    public void replay(List<Event> events){
        for(Event event : events){
            if(event instanceof ConsultantCreated){
                apply((ConsultantCreated) event);
            }
        }
    }

    private  void  apply(ConsultantCreated event){
        this.consultantId=event.getConsultantId();
        this.name = event.getName();
        this.password = event.getPassword();
    }

    @Override
    public String toString() {
        return "ConsultantReadModel{" +
                "consultantId=" + consultantId.value() +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
