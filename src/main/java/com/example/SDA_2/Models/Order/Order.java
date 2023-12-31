package com.example.SDA_2.Models.Order;

import com.example.SDA_2.Data.CustomerDatabase;
import com.example.SDA_2.Models.Customer;
import com.example.SDA_2.Models.Product.Product;
import com.example.SDA_2.Models.Product.ProductHelper;

import java.time.LocalDateTime;

public abstract class Order {
    protected String id;
    protected float Total = 0;
    protected  Customer owner =null;
    protected String ownerID;
    protected float shippingFee=200;
    protected boolean shipped=false,placed=false;
    protected LocalDateTime shippingTime;

    public boolean isShipped() {
        return shipped;
    }

    public void setShipped(boolean shipped) {
        this.shipped = shipped;
    }

    public boolean isPlaced() {
        return placed;
    }

    public void setPlaced(boolean placed) {
        this.placed = placed;
    }

    protected CustomerDatabase customerDatabase = CustomerDatabase.getCustomerinstance();


    public Order() {

    }

    public Customer getOwner() {
        this.owner = customerDatabase.getCustomerByUsername(ownerID);
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = customerDatabase.getCustomerByUsername(ownerID);
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
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

    public String getOwnerID() {
        return ownerID;
    }



    public abstract float calcTotal();
    public abstract void printOrder();
    public abstract boolean deductFees();
    public abstract boolean shipOrder(float f);
    public abstract boolean Cancelship(float f);
    public boolean addOrder(Order o){
        throw new UnsupportedOperationException();
    }
    public void removeOrder(Order o){
        throw new UnsupportedOperationException();
    }
    public void getOrder(Order o) {
        throw new UnsupportedOperationException();
    }

    public abstract boolean addProduct(Customer c, ProductHelper... p);

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", Total=" + Total +
                ", owner=" + owner +
                ", ownerID='" + ownerID + '\'' +
                '}';
    }
}

