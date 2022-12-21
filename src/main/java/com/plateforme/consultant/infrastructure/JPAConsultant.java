package com.plateforme.consultant.infrastructure;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.plateforme.consultant.domain.*;
import com.plateforme.kernel.Event;
import org.springframework.web.ErrorResponseException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class JPAConsultant implements Consultants {

    private final  ConsultantEntityRepository consultantEntityRepository;



    public JPAConsultant(ConsultantEntityRepository consultantEntityRepository){
        this.consultantEntityRepository =consultantEntityRepository;
    }


    @Override
    public ConsultantId nextId() {
        return ConsultantId.of(UUID.randomUUID());
    }

    @Override
    public Consultant findById(ConsultantId consultantId) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        final Gson gson = gsonBuilder.create();
        final Optional<ConsultantEntity> optionalConsultantEntity = consultantEntityRepository.findById(consultantId.value());
        if (optionalConsultantEntity.isPresent()) {
            var consultantEntity = optionalConsultantEntity.get();

            final List<EventEntity> accountEntityRecordedEvents = consultantEntity.getRecordedEvents();
            final List<Event> result = new ArrayList<>();
            for (EventEntity eventEntity : accountEntityRecordedEvents) {
                try {
                    final Event event = (Event) gson.fromJson(eventEntity.getData(), Class.forName(eventEntity.getClassname()));
                    result.add(event);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }

            return new Consultant(consultantId,
                    consultantEntity.getFirstName(),consultantEntity.getLastName() , consultantEntity.getModality(),
                    consultantEntity.getStartDate(), consultantEntity.getEndDate(), consultantEntity.getTjm()
                    ,  result);
        }
        throw ConsultantException.notFoundAccountId(consultantId);

    }

    @Override
    public void add(Consultant consultant) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        final Gson gson = gsonBuilder.create();
        var consultantEntity = new ConsultantEntity(UUID.fromString(consultant.getConsultantId().value()),
                consultant.getFirstName(),
                consultant.getLastName(),
                consultant.getModality(),
                consultant.getStartDate(),
                consultant.getEndDate(),
                consultant.getTjm(),
                consultant.getRecordedEvents().stream().map(event ->
                        new EventEntity(event.getClass().getName(), gson.toJson(event))).collect(Collectors.toList()));
        consultantEntityRepository.save(consultantEntity);
    }

    @Override
    public void update(Consultant consultant) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        final Gson gson = gsonBuilder.create();
        var consultantEntity = new ConsultantEntity(UUID.fromString(consultant.getConsultantId().value()),
                consultant.getFirstName(),
                consultant.getLastName(),
                consultant.getModality(),
                consultant.getStartDate(),
                consultant.getEndDate(),
                consultant.getTjm(),
                consultant.getRecordedEvents().stream().map(event ->
                        new EventEntity(event.getClass().getName(), gson.toJson(event))).collect(Collectors.toList()));
        consultantEntityRepository.save(consultantEntity);
    }

    @Override
    public List<Consultant> search(int page, int size, String filterOne, String filterAnd, String orders) {
        return null;
    }
}
