package com.example.SDA_2.Models.Notification.noooo;

import com.example.SDA_2.Models.Order.Order;

public class Confirmation implements Notification{

    OrderPlacementNotification orderPlacementNotification;
    @Override
    public String sendNotification(Order o)
    {
       return orderPlacementNotification.generateNotification(o);
    }
}
