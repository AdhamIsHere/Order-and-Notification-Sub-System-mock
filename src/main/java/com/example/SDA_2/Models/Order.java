package com.example.SDA_2.Models;

import java.util.ArrayList;

public abstract class Order {
    String id;
    float Total = 0;
    Customer owner;
    public abstract int calcTotal();
    public abstract void printOrder();
    public boolean addOrder(Order o){
        throw new UnsupportedOperationException();
    }
    public void removeOrder(Order o){
        throw new UnsupportedOperationException();
    }
    public void getOrder(Order o) {
        throw new UnsupportedOperationException();
    }

    public abstract boolean addProduct(Customer c, Product... p);



}
