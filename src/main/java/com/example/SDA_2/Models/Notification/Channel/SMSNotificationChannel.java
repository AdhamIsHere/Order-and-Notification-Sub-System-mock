package com.example.SDA_2.Models.Notification.Channel;

public class SMSNotificationChannel implements NotificationChannel {
    @Override
    public String sendNotification(String message) {

        return ("Sent Through SMS: " + message);

    }
}