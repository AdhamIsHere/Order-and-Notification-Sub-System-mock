package com.example.SDA_2.Services;

import com.example.SDA_2.Models.Order.ShipmentManager;
import com.example.SDA_2.Models.Response;
import org.springframework.stereotype.Service;

@Service
public class ShipmentServiceImp implements ShipmentService{
    ShipmentManager shipmentManager= new ShipmentManager();
    @Override
    public Response shipOrder(String id) {
        return shipmentManager.ShipOrder(id);
    }

    @Override
    public Response cancelShip(String id) {
        return shipmentManager.CancelShipment(id);
    }
}
