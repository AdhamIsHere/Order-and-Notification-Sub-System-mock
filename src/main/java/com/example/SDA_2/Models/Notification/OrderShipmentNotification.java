package com.example.SDA_2.Models.Notification;

public class OrderShipmentNotification implements NotificationTemplate {
    @Override
    public String generateNotification(String... placeholders)
    {
        return " Dear Nabil, your booking of the item mobile charger is confirmed, thanks for using our store :)";
    }
}
