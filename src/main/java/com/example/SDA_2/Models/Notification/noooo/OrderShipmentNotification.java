package com.example.SDA_2.Models.Notification.noooo;

import com.example.SDA_2.Models.Order.Order;

public class OrderShipmentNotification implements NotificationTemplate {


    @Override
    public String generateNotification(Order order) {
        return "Dear " + order.getOwner().getName() + " , your booking of the " +  order.getId() + " shipped,. thanks for using our store :)";
    }
}
