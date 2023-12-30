package com.example.SDA_2.Data;

import com.example.SDA_2.Models.Customer;
import com.example.SDA_2.Models.Order.Order;

import java.util.ArrayList;
import java.util.HashMap;

public class OrdersDatabase
{
    private static OrdersDatabase Orderinstance=null;
    private OrdersDatabase(){}
public static OrdersDatabase getInstance()
{
    if (Orderinstance == null)
    {
        Orderinstance = new OrdersDatabase();
    }
    return Orderinstance;

}
    static HashMap<Customer, ArrayList<Order>> orders = new HashMap<>();

    public static ArrayList<Order> getCustomerOrder(Customer c)
    {
        return orders.get(c);
    }
    public static void addNewOrder(Customer c, Order o)
    {
        if(orders.containsKey(c))
        {
            orders.get(c).add(o);
        }else
        {
            ArrayList<Order> newOrder=new ArrayList<>();
            newOrder.add(o);
            orders.put(c,newOrder);
        }
    }
    public static boolean removeOrder(Customer c, Order o)
    {
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
