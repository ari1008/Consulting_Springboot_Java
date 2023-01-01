package com.plateforme.consultant.domain;

import com.plateforme.consultant.infrastructure.ConsultantEntity;

import java.util.List;

public interface Consultants {

    ConsultantId nextId();

    Consultant findById(ConsultantId consultantId);

    void add(Consultant consultant);

    void update(Consultant consultant);

    void saveAll(List<Consultant> consultants);

    List<Consultant> search(int page, int size, String filterOne,
                            String filterAnd, String orders) throws Exception;
}
