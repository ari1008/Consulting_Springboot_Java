package com.plateforme.consultant.domain;

import java.util.List;

public interface Consultants {

    ConsultantId nextId();

    Consultant findById(ConsultantId consultantId);

    void add(Consultant consultant);

    void update(Consultant consultant);

    List<Consultant> search(int page, int size, String filterOne,
                            String filterAnd, String orders);
}
