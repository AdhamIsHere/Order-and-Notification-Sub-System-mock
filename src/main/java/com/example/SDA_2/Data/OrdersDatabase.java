package com.example.SDA_2.Data;

import com.example.SDA_2.Models.Customer;
import com.example.SDA_2.Models.Order;

import java.util.ArrayList;
import java.util.HashMap;

public class OrdersDatabase {
    static HashMap<Customer, ArrayList<Order>> orders = new HashMap<>();

    public static ArrayList<Order> getCustomerOrder(Customer c){
        return orders.get(c);
    }
    public static void addNewOrder(Customer c, Order o){
        if(orders.containsKey(c)){
            orders.get(c).add(o);
        }else{
            ArrayList<Order> newOrder=new ArrayList<>();
            newOrder.add(o);
            orders.put(c,newOrder);
        }
    }
    public static boolean removeOrder(Customer c, Order o){
        if(!orders.containsKey(c)){
            return false;
        }
        if(!orders.get(c).contains(o)){
            return false;
        }
        orders.get(c).remove(o);
        return true;
    }
}
