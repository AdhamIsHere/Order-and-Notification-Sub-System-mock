package com.example.SDA_2.Models;

import java.util.ArrayList;

public abstract class Order {
    float Total = 0;
    String owner;
    public abstract void calcTotal();
    public abstract void printOrder();
    public void addOrder(Order o){
        throw new UnsupportedOperationException();
    }
    public void removeOrder(Order o){
        throw new UnsupportedOperationException();
    }
    public void getOrder(Order o) {
        throw new UnsupportedOperationException();
    }



}
