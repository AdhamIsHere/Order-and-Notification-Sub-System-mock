package com.example.SDA_2.Models;

import java.util.ArrayList;
import java.util.HashMap;

public class Compound extends Order {

    HashMap<Customer, Order> orders = new HashMap<>();

    Compound() {

    }

    @Override
    public int calcTotal() {
        int sum = 0;
        for (Customer i : orders.keySet()) {
            sum += orders.get(i).calcTotal();
        }
        Total = sum;
        return sum;
    }

    @Override
    public void printOrder() {

        for (Customer c : orders.keySet()) {
            orders.get(c).printOrder();
        }
    }


    public boolean addProduct(Customer c, Product... p) {

        Order NewOrder = new SimpleOrder();
        NewOrder.addProduct(c, p);
        orders.put(c, NewOrder);
        return true;
    }
}
