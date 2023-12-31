package com.example.SDA_2.Models.Notification;

import com.example.SDA_2.Models.Order.Order;

public class OrderShipmentCancelNotification extends Notification{
    @Override
    public void setMessage(Order order) {
        this.message =  "Dear " + order.getOwner().getName() + " , your Shipping of the " +  order.getId() + " Has been Cancelled ,. thanks for using our store :)";

    }
}
