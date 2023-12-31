package com.example.SDA_2.Models.Notification.Channel;

public class EmailNotificationChannel implements NotificationChannel {
    @Override
    public String sendNotification(String message) {
        return ("Email..." + message);


    }
}