package com.example.SDA_2.Models.Notification;

public interface NotificationTemplate {
    String generateNotification(String... placeholders);
}
