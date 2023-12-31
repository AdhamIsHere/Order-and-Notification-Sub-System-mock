package com.example.SDA_2.Controller;

import com.example.SDA_2.Data.CustomerDatabase;
import com.example.SDA_2.Data.OrdersDatabase;
import com.example.SDA_2.Models.Notification.*;
import com.example.SDA_2.Models.Response;
import com.example.SDA_2.Services.ShipmentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ship")
public class ShipmentController {
    Notification notification = null;
    NotificationService no_ser = new NotificationService();
    @Autowired
    ShipmentServiceImp shipmentServiceImp;
    CustomerDatabase customerDatabase = CustomerDatabase.getCustomerinstance();
    OrdersDatabase ordersDatabase = OrdersDatabase.getInstance();

    @PutMapping("confirm/{id}")
    public String shipOrder(@PathVariable String id) {
        Response res = shipmentServiceImp.shipOrder(id);
        if (res.isStatus()) {
            notification = new OrderShipmentNotification();
        } else {
            notification = new FailNotification();

        }
        String channel = customerDatabase.getCustomerByUsername(ordersDatabase.getOrderByID(id).getOwnerID()).getChannelType();

        no_ser.setNotificationChannel(customerDatabase.messageChannels.get(channel));

        notification.setMessage(ordersDatabase.getOrderByID(id));
        return no_ser.send(notification.getMessage());
    }

    @PutMapping("cancel/{id}")
    public String cancelShip(@PathVariable String id) {
        Response res = shipmentServiceImp.cancelShip(id);
        if (res.isStatus()) {
            notification = new OrderShipmentCancelNotification();
        } else {
            notification = new FailNotification();
        }
        String channel = customerDatabase.getCustomerByUsername(ordersDatabase.getOrderByID(id).getOwnerID()).getChannelType();

        no_ser.setNotificationChannel(customerDatabase.messageChannels.get(channel));

        notification.setMessage(ordersDatabase.getOrderByID(id));
        return no_ser.send(notification.getMessage());
    }
}
