package com.plateforme.consultant;


import com.plateforme.consultant.infrastructure.repository.ResourceRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(repositoryBaseClass = ResourceRepositoryImpl.class)
public class ConsultingApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsultingApplication.class, args);
    }
}
