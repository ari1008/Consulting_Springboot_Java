package com.plateforme.consultant.application.events;

import com.plateforme.consultant.application.Notifications;
import com.plateforme.kernel.EventHandler;

public class ConsultantSearchEventHandler implements EventHandler<ConsultantSearchApplicationEvent> {
    private final Notifications notifications;

    public ConsultantSearchEventHandler(Notifications notifications) {
        this.notifications = notifications;
    }

    @Override
    public void handle(ConsultantSearchApplicationEvent event) {
        notifications.notify(String.format("Notification of the search consultant  size of  %s  page  %s.", event.getSize(), event.getPage()));
    }
}
