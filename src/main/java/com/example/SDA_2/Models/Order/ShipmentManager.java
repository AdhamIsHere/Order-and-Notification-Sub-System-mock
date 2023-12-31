package com.example.SDA_2.Models.Order;

import com.example.SDA_2.Data.OrdersDatabase;
import com.example.SDA_2.Models.Response;

public class ShipmentManager {
    private OrdersDatabase ordersDatabase = OrdersDatabase.getInstance();

    public Response ShipOrder(String id) {
        Response res = new Response();
        Order o = ordersDatabase.getOrderByID(id);
        res.setStatus(o.shipOrder(o.shippingFee));
        if (res.isStatus()) {
            res.setMessage("Order Shipped");
        } else {
            res.setMessage("Order not Shipped");
        }
        return res;
    }

    public Response CancelShipment(String id) {
        Response res = new Response();
        Order o = ordersDatabase.getOrderByID(id);
        res.setStatus(o.Cancelship(o.shippingFee));
        if (res.isStatus()) {
            res.setMessage("Shipping Cancelled");
        } else {
            res.setMessage("Can't Cancel Shipment");
        }
        return res;
    }
}
