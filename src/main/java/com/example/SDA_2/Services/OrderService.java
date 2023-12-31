package com.example.SDA_2.Services;

import com.example.SDA_2.Models.Order.Order;
import com.example.SDA_2.Models.Response;

public interface OrderService {
    public Response createOrder(Order o);
    public Response cancelOrder(String id);
    public Response confirmOrder(String id);



}
