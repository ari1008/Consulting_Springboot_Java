package com.plateforme.consultant.infrastructure;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document(collection = "consultant")
public class ConsultantEntity {
    @Id
    private UUID id;
    @UniqueElements
    private String name;

    private String password;

    private List<EventEntity> recordedEvents;

    public UUID getId(){
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ConsultantEntity(UUID id, String name, String password, List<EventEntity> recordedEvents) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.recordedEvents = recordedEvents;
    }

    public String getName(){return name;}

    public String getPassword(){return password;}

    public void setName(String name){this.name = name;}
    public void setPassword(String password){this.password = password;}

    public List<EventEntity> getRecordedEvents() {
        return recordedEvents;
    }

    public void setRecordedEvents(List<EventEntity> recordedEvents) {
        this.recordedEvents = recordedEvents;
    }
}
