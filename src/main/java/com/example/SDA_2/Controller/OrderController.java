package com.example.SDA_2.Controller;

import com.example.SDA_2.Data.CustomerDatabase;
import com.example.SDA_2.Data.OrdersDatabase;
import com.example.SDA_2.Models.*;
import com.example.SDA_2.Models.Notification.*;
import com.example.SDA_2.Models.Order.CompoundOrder;
import com.example.SDA_2.Models.Order.Order;
import com.example.SDA_2.Models.Order.SimpleOrder;
import com.example.SDA_2.Services.OrderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/order")
public class OrderController {
    Notification notification = null;
    NotificationService no_ser = new NotificationService() ;
    @Autowired
    OrderServiceImp orderServiceImp;
    CustomerDatabase customerDatabase= CustomerDatabase.getCustomerinstance();
    OrdersDatabase ordersDatabase=OrdersDatabase.getInstance();


    @PostMapping("/create/simple")
    public String createSimpleOrder(@RequestBody SimpleOrder o) {
        Response res = new Response();
        String channel =  customerDatabase.getCustomerByUsername(o.getOwnerID()).getChannelType();

        no_ser.setNotificationChannel(customerDatabase.messageChannels.get(channel));

        if (CustomerController.loggedin == null) {
            res.setStatus(false);
            res.setMessage("Must Login First");
            notification = new FailNotification();
            notification.setMessage(o);
            return res.getMessage();
        }
        o.calcTotal();
        res = orderServiceImp.createOrder(o);
        if (res.isStatus()) {
            notification = new OrderPlacedNotification();
        } else {
            notification = new FailNotification();

        }
        notification.setMessage(o);
        return no_ser.send (notification.getMessage());
    }

    @PostMapping("/create/compound")
    public String createCompoundOrder(@RequestBody CompoundOrder o) {
        Response res = new Response();
        String channel =  customerDatabase.getCustomerByUsername(o.getOwnerID()).getChannelType();

        no_ser.setNotificationChannel(customerDatabase.messageChannels.get(channel));
        if (CustomerController.loggedin == null) {
            res.setStatus(false);
            res.setMessage("Must Login First");
            return res.getMessage();
        }
        res = orderServiceImp.createOrder(o);
        o.updateDatabase();
        if (res.isStatus()) {
            notification = new OrderPlacedNotification();

        } else {
            notification = new FailNotification();

        }
        notification.setMessage(o);
        return no_ser.send (notification.getMessage());
    }

    @PutMapping("confirm/{id}")
    public String confirmOrder(@PathVariable String id) {
        Response res = orderServiceImp.confirmOrder(id);
        if (res.isStatus()) {
            notification = new OrderConfirmedNotification();
        } else {
            notification = new FailNotification();
        }
        String channel =  customerDatabase.getCustomerByUsername(ordersDatabase.getOrderByID(id).getOwnerID()).getChannelType();

        no_ser.setNotificationChannel(customerDatabase.messageChannels.get(channel));

        notification.setMessage(ordersDatabase.getOrderByID(id));
        return  no_ser.send (notification.getMessage());
    }

    @GetMapping("/getAll")
    public HashMap<Customer, ArrayList<Order>> getAll() {
        return OrdersDatabase.getInstance().orders;
    }


}
