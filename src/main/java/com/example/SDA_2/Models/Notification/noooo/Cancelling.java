package com.example.SDA_2.Models.Notification.noooo;

import com.example.SDA_2.Models.Order.Order;

public class Cancelling implements Notification{

    OrderCancellingNotification orderCancellingNotification;
    @Override
    public String sendNotification(Order o) {
        return orderCancellingNotification.generateNotification(o);
    }
}
