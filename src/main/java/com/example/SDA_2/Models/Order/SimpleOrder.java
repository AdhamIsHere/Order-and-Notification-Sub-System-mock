package com.example.SDA_2.Models.Order;

import com.example.SDA_2.Models.Customer;
import com.example.SDA_2.Models.Product.Product;

import java.util.ArrayList;
import java.util.List;

public class SimpleOrder extends Order {
    ArrayList <Product> products;

    public SimpleOrder(String id, String  owner,ArrayList<Product> products) {
        super(id,owner);
        this.products = products;
        this.Total=calcTotal();
    }

    public SimpleOrder() {

    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }


    @Override
    public float calcTotal() {
        float sum=0;
        for(Product i : products)
        {
            sum += i.getPrice();
        }
        System.out.println("Total price of order "+this.id+" is "+sum);
        Total=sum;
        return sum;
    }

    @Override
    public void printOrder() {

        for(Product i : products)
        {
            System.out.println(i.toString()) ;
        }

    }

    @Override
    public boolean addProduct(Customer c, Product... p) {
        products.addAll(List.of(p));
        owner = c ;
        return true ;
    }

    @Override
    public String toString() {
        return "SimpleOrder{" +
                "products=" + products +
                ", id='" + id + '\'' +
                ", Total=" + Total +
                ", owner1=" + owner +
                ", owner='" + ownerID + '\'' +
                '}';
    }
}
