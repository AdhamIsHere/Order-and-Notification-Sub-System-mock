package com.example.SDA_2.Models.Order;

import com.example.SDA_2.Data.CustomerDatabase;
import com.example.SDA_2.Models.Customer;
import com.example.SDA_2.Models.Product.Product;

public abstract class Order {
    String id;
    float Total = 0;
    Customer owner =null;
    String ownerHelper;

    public Order(String id, String owner) {
        this.id = id;
        Total = calcTotal();
        this.owner = CustomerDatabase.getCustomerByUsername(owner);
    }

    public Order() {

    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public void setOwnerHelper(String ownerHelper) {
        this.ownerHelper = ownerHelper;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(float total) {
        Total = total;
    }

    public Customer getOwnerHelper() {
        return owner;
    }



    public abstract float calcTotal();
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

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", Total=" + Total +
                ", owner1=" + owner +
                ", owner='" + ownerHelper + '\'' +
                '}';
    }
}
