package com.example.SDA_2.Models.Notification;

import com.example.SDA_2.Models.Order.Order;

public class OrderCancellingNotification extends Notification{
    @Override
    public void setMessage(Order order) {
        this.message =  "Dear " + order.getOwner().getName() + " , your booking of the " +  order.getId() + " is Cancelled,. thanks for using our store :)";
    }
}