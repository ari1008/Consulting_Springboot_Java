package com.plateforme.consultant.infrastructure;

import com.plateforme.consultant.application.Notifications;

public final class LogNotifications implements Notifications {
    @Override
    public void notify(String message) {
        System.out.println(message);
    }
}
