package com.plateforme.consultant;


import com.plateforme.consultant.application.events.ConsultantCreatedEventHandler;
import com.plateforme.consultant.application.events.ConsultantSearchEventHandler;
import com.plateforme.consultant.application.events.ConsultantUpdateEventHandler;
import com.plateforme.consultant.application.service.CreateConsultantService;
import com.plateforme.consultant.application.service.SearchConsultantService;
import com.plateforme.consultant.application.service.UpdateConsultantService;
import com.plateforme.consultant.infrastructure.ConsultantEntityRepository;
import com.plateforme.consultant.infrastructure.JPAConsultant;
import com.plateforme.consultant.infrastructure.LogNotifications;
import com.plateforme.kernel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SuppressWarnings("all")
public class ApplicationConfiguration {
    @Autowired
    private ConsultantEntityRepository consultantEntityRepository;

    @Bean
    public JPAConsultant consultant(){return  new JPAConsultant(consultantEntityRepository);}



    @Bean
    public CommandBus commandBus(){return BusFactory.defaultCommandBus();}

    @Bean
    public QueryBus queryBus(){return BusFactory.defaultQueryBus();}

    @Bean
    public EventDispatcher eventDispatcher(){return DefaultEventDispatcher.create();}

    @Bean
    public CreateConsultantService createAccountService() {
        return new CreateConsultantService(consultant(), eventDispatcher());
    }

    @Bean
    public SearchConsultantService searchConsultantService(){
        return new SearchConsultantService(consultant(), eventDispatcher());
    }

    @Bean
    public UpdateConsultantService updateConsultantService(){
        return new UpdateConsultantService(consultant(), eventDispatcher());
    }

    @Bean
    public LogNotifications notifications() {
        return new LogNotifications();
    }

    @Bean
    public ConsultantCreatedEventHandler consultantCreatedEventHandler() {
        return new ConsultantCreatedEventHandler(notifications());
    }

    @Bean
    public ConsultantUpdateEventHandler consultantUpdateEventHandler(){
        return new ConsultantUpdateEventHandler(notifications());
    }


    @Bean
    public ConsultantSearchEventHandler  consultantSearchEventHandler(){
        return  new ConsultantSearchEventHandler(notifications());
    }


}
