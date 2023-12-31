package com.example.SDA_2.Models.Notification;

import com.example.SDA_2.Models.Order.Order;

public interface Notification {
    String sendNotification(Order o);
}
