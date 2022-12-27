package com.plateforme.consultant.infrastructure;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.plateforme.consultant.domain.*;
import com.plateforme.consultant.infrastructure.dto.FilterCondition;
import com.plateforme.consultant.infrastructure.dto.PageResponse;
import com.plateforme.consultant.infrastructure.support.FilterBuilderService;
import com.plateforme.consultant.infrastructure.support.GenericFilterCriteriaBuilder;
import com.plateforme.kernel.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JPAConsultant implements Consultants {

    private final  ConsultantEntityRepository consultantEntityRepository;

    @Autowired
    private ConsultantSearchRepository consultantSearchRepository;



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
    public List<Consultant> search(int page, int size, String filterOr, String filterAnd, String orders) throws Exception {
        PageResponse<ConsultantEntity> response = new PageResponse<>();
        FilterBuilderService filterBuilderService = new FilterBuilderService();
        Pageable pageable = filterBuilderService.getPageable(size, page, orders);
        GenericFilterCriteriaBuilder filterCriteriaBuilder = new GenericFilterCriteriaBuilder();
        List<FilterCondition> andConditions = filterBuilderService.createFilterCondition(filterAnd);
        List<FilterCondition> orConditions = filterBuilderService.createFilterCondition(filterOr);
        Query query = filterCriteriaBuilder.addCondition(andConditions, orConditions);
        MongoServiceConsultant mongoServiceConsultant = new MongoServiceConsultant(consultantSearchRepository);
        Page<ConsultantEntity> pg = mongoServiceConsultant.getPage(query, pageable);
        response.setPageStats(pg, pg.getContent());
        List<ConsultantEntity> consultantEntityList = response.getItems();
        return transformConsultantEntityToConsultant(consultantEntityList);




    }

    private List<Consultant> transformConsultantEntityToConsultant(List<ConsultantEntity> consultantEntityList){
        Stream<ConsultantEntity> stream = listToStream(consultantEntityList);
        return stream.map(this::createConsultant).toList();
    }

    private static <T> Stream<T> listToStream (List<T> list) {
        return list.stream();
    }


    private Consultant createConsultant(ConsultantEntity consultantEntity){
        return new Consultant(ConsultantId.of(consultantEntity.getId()),
                consultantEntity.getFirstName(),
                consultantEntity.getLastName(),
                consultantEntity.getModality(),
                consultantEntity.getStartDate(),
                consultantEntity.getEndDate(),
                consultantEntity.getTjm());
    }
}
