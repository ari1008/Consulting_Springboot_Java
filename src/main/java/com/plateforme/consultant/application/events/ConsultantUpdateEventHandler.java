package com.plateforme.consultant.application.events;

import com.plateforme.consultant.application.Notifications;
import com.plateforme.kernel.EventHandler;

public class ConsultantUpdateEventHandler implements EventHandler<ConsultantUpdateApplicationEvent> {

    private final Notifications notifications;

    public ConsultantUpdateEventHandler(Notifications notifications) {
        this.notifications = notifications;
    }


    @Override
    public void handle(ConsultantUpdateApplicationEvent event) {
        notifications.notify(String.format("Notification of the consultant update %s with %s.", event.getConsultantId(), event.getFirstName()));
    }
}
