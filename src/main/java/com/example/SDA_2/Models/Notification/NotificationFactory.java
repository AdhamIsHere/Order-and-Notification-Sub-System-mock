package com.example.SDA_2.Models.Notification;

import com.example.SDA_2.Models.Order.Order;

public interface NotificationFactory {
    public Notification createShippingNotification(Order o);
    public Notification createConfirmationNotification(Order o);
    public Notification createCancellationNotification(Order o);
}
