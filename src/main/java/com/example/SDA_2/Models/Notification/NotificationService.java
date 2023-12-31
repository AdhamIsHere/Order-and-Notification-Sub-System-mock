package com.example.SDA_2.Models.Notification;

import com.example.SDA_2.Models.Notification.Channel.NotificationChannel;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    Notification notification;
    NotificationChannel notificationChannel;

    public String send(String message)
    {
        return notificationChannel.sendNotification(message);
    }

    public void setNotificationChannel(NotificationChannel notificationChannel)
    {
        this.notificationChannel=notificationChannel;
    }
}
