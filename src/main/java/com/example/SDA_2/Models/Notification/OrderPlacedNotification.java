package com.example.SDA_2.Models.Notification;

import com.example.SDA_2.Models.Order.Order;

public class OrderPlacedNotification extends Notification {
    @Override
    public void setMessage(Order order) {
        this.message = "Dear " + order.getOwner().getName() + " , your order " + order.getId() + " is placed, please confirm it :)";
    }
}
