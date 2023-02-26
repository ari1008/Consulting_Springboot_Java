package com.plateforme.consultant.infrastructure.repository;


import com.plateforme.consultant.infrastructure.entity.ConsultantEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultantSearchRepository extends ResourceRepository<ConsultantEntity, String> {
}
