package com.example.SDA_2.Models.Notification.noooo;

import com.example.SDA_2.Models.Order.Order;

public class Shipping implements Notification
{

    OrderShipmentNotification orderShipmentNotification;
    @Override
    public String sendNotification(Order o)
    {
        return orderShipmentNotification.generateNotification(o);
    }
}
