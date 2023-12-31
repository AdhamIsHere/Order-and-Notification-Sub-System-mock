package com.example.SDA_2.Models.Notification;

import com.example.SDA_2.Models.Order.Order;

public abstract class Notification {

    String message;

    public String getMessage() {
        return message;
    }

    abstract public void setMessage(Order order);
}
