package com.example.SDA_2.Services;

import com.example.SDA_2.Controller.CustomerController;
import com.example.SDA_2.Data.OrdersDatabase;
import com.example.SDA_2.Models.Order.Order;
import com.example.SDA_2.Models.Response;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImp implements OrderService{
    OrdersDatabase ordersDatabase = OrdersDatabase.getInstance();
    @Override
    public Response createOrder(Order o) {
        Response res = new Response();
        o.setOwner(CustomerController.loggedin);
        ordersDatabase.addNewOrder(CustomerController.loggedin,o);
        System.out.println(o);
        res.setStatus(true);
        res.setMessage("Order created");
        return res;
    }

    @Override
    public Response cancelOrder(String id) {
        Response res = new Response();
        return res;
    }
}
