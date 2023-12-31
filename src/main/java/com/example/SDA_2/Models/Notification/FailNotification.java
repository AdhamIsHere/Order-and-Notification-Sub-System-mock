package com.example.SDA_2.Models.Notification;

import com.example.SDA_2.Models.Order.Order;

public class FailNotification extends Notification {
    @Override
    public void setMessage(Order order) {
        this.message =  "Dear " + order.getOwner().getName() + " there was an error during this transaction please try again :(";
    }
}
