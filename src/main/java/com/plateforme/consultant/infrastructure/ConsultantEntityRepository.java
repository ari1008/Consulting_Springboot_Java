package com.plateforme.consultant.infrastructure;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface ConsultantEntityRepository extends MongoRepository<ConsultantEntity, String>  {
}
