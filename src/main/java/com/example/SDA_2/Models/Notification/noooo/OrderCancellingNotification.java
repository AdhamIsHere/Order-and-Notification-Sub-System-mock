package com.example.SDA_2.Models.Notification.noooo;

import com.example.SDA_2.Models.Order.Order;

public class OrderCancellingNotification implements NotificationTemplate{

    @Override
    public String generateNotification(Order order)
    {
        return "Dear " + order.getOwner().getName() + " , your booking of the " +  order.getId() + " is Cancelled. thanks for using our store :)";
    }
}
