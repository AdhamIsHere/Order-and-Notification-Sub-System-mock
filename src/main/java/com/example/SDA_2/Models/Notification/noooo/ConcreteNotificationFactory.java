package com.example.SDA_2.Models.Notification.noooo;

public class ConcreteNotificationFactory implements NotificationFactory
{

    @Override
    public Notification createNotification(String type) {
        switch (type)
        {
            case "cancelling":
                return new Cancelling();
            case "confirmation":
                return new Confirmation();
            case "shipping":
                return new Shipping();
            default:
                throw new IllegalArgumentException("Invalid notification type");
        }
    }
}
