package com.example.SDA_2.Models.Order;

import com.example.SDA_2.Models.Customer;
import com.example.SDA_2.Models.Product.Product;

import java.util.ArrayList;

public class CompoundOrder extends Order {

    ArrayList<Order> orders = new ArrayList<>();

    public CompoundOrder(String id, String owner,ArrayList<Order> orders) {
        super(id, owner);
        this.orders=orders;
    }


    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    @Override
    public float calcTotal() {
        float sum = 0;
        for (Order i : orders) {
            sum += i.calcTotal();
        }
        Total = sum;
        return sum;
    }

    @Override
    public void printOrder() {

        for (Order c : orders) {
            c.printOrder();
        }
    }


    public boolean addProduct(Customer c, Product... p) {

        Order NewOrder = new SimpleOrder();
        NewOrder.addProduct(c, p);
        orders.add(NewOrder);
        return true;
    }
}
