package com.plateforme.consultant.domain;

public interface Consultants {

    ConsultantId nextId();

    Consultant findById(ConsultantId consultantId);

    void add(Consultant consultant);

    void update(Consultant consultant);
}
