package com.example.SDA_2.Controller;

import com.example.SDA_2.Data.OrdersDatabase;
import com.example.SDA_2.Models.Notification.FailNotification;
import com.example.SDA_2.Models.Notification.Notification;
import com.example.SDA_2.Models.Notification.OrderShipmentCancelNotification;
import com.example.SDA_2.Models.Notification.OrderShipmentNotification;
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
    Notification notification=null;
    @Autowired
    ShipmentServiceImp shipmentServiceImp;
    @PutMapping("confirm/{id}")
    public String shipOrder(@PathVariable String id){
        Response res = shipmentServiceImp.shipOrder(id);
        if(res.isStatus()){
            notification= new OrderShipmentNotification();
        }else{
            notification=new FailNotification();
        }
        notification.setMessage(OrdersDatabase.getInstance().getOrderByID(id));
        return notification.getMessage();
    }
    @PutMapping("cancel/{id}")
    public String cancelShip(@PathVariable String id){
       Response res = shipmentServiceImp.cancelShip(id);
        if(res.isStatus()){
            notification= new OrderShipmentCancelNotification();
        }else{
            notification=new FailNotification();
        }
        notification.setMessage(OrdersDatabase.getInstance().getOrderByID(id));
        return notification.getMessage();
    }
}
