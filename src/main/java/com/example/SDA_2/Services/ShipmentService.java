package com.example.SDA_2.Services;

import com.example.SDA_2.Models.Response;

public interface ShipmentService {
    public Response shipOrder(String id);
    public Response cancelShip(String id);
}
