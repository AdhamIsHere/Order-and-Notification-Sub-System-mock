package com.example.SDA_2.Models.Notification;

public abstract class NotificationsManagerFactory {
    public static NotificationsManager createNotificationsManager()
    {
        NotificationsManager manager = new NotificationsManager();
        manager.initialize();
        return manager;
    }
}
