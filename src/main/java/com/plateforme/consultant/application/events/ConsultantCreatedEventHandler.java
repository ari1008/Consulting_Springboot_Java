package com.plateforme.consultant.application.events;

import com.plateforme.consultant.application.Notifications;
import com.plateforme.kernel.EventHandler;



public class ConsultantCreatedEventHandler  implements EventHandler<ConsultantCreatedApplicationEvent> {

    private final Notifications notifications;

    public  ConsultantCreatedEventHandler(Notifications notifications){this.notifications = notifications;}
    @Override
    public void handle(ConsultantCreatedApplicationEvent event) {
        notifications.notify(String.format("Notification of the consultant creation %s with %s.", event.getConsultantId(), event.getFirstName()));
    }
}
