package com.plateforme.consultant.infrastructure.repository;

import com.plateforme.consultant.infrastructure.entity.ConsultantEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultantEntityRepository extends MongoRepository<ConsultantEntity, String> {
}
