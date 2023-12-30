package com.example.SDA_2.Models.Order;

import com.example.SDA_2.Data.CustomerDatabase;
import com.example.SDA_2.Models.Customer;
import com.example.SDA_2.Models.Product.Product;

import java.util.ArrayList;

public class CompoundOrder extends Order {


    ArrayList<SimpleOrder> orders = new ArrayList<>();



    public CompoundOrder(String id,String ownerID , ArrayList<SimpleOrder> orders) {
        this.id=id;
        this.ownerID=ownerID;
        owner= CustomerDatabase.getCustomerByUsername(ownerID);
        this.orders = orders;
        this.Total=calcTotal();
    }

    public ArrayList<SimpleOrder> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<SimpleOrder> orders) {
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

        SimpleOrder NewOrder = new SimpleOrder();
        NewOrder.addProduct(c, p);
        orders.add(NewOrder);
        return true;
    }
}
