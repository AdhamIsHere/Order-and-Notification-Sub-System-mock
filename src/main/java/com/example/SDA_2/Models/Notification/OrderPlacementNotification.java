package com.example.SDA_2.Models.Notification;

public class OrderPlacementNotification implements NotificationTemplate {
    @Override
    public String generateNotification(String... placeholders) {

        return "Dear {x} , your booking of the {y} is confirmed. thanks for using our store :)";

    }
}
