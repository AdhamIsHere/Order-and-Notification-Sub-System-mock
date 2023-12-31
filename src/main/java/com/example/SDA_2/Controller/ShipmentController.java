package com.example.SDA_2.Controller;

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
    @Autowired
    ShipmentServiceImp shipmentServiceImp;
    @PutMapping("confirm/{id}")
    public Response shipOrder(@PathVariable String id){
        return shipmentServiceImp.shipOrder(id);
    }
    @PutMapping("cancel/{id}")
    public Response cancelShip(@PathVariable String id){
        return shipmentServiceImp.cancelShip(id);
    }
}
