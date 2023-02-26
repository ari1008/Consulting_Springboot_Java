package com.plateforme.consultant.infrastructure;

import com.plateforme.consultant.infrastructure.entity.ConsultantEntity;
import com.plateforme.consultant.infrastructure.repository.ConsultantSearchRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class MongoServiceConsultant {

    private final ConsultantSearchRepository consultantSearchRepository;

    public MongoServiceConsultant(ConsultantSearchRepository consultantSearchRepository) {
        this.consultantSearchRepository = consultantSearchRepository;
    }


    public List<ConsultantEntity> getAll(Query query) {
        return consultantSearchRepository.findAll(query);
    }


    public Page<ConsultantEntity> getPage(Query query, Pageable pageable) {
        return consultantSearchRepository.findAll(query, pageable);
    }
}

