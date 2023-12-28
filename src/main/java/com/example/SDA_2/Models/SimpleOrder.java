package com.example.SDA_2.Models;

import java.util.ArrayList;

public class SimpleOrder extends Order {
    ArrayList <Product> products;

    SimpleOrder()
    {
        products = new ArrayList<>() ;
    }
    @Override
    public void calcTotal() {

        for(Product i : products)
        {
            Total += i.price;
        }
        System.out.println("Total price is "+Total);

    }

    @Override
    public void printOrder() {

        for(Product i : products)
        {
            System.out.println(i.toString()) ;
        }

    }

    public void addProduct(ArrayList<Product> p) {
        products.addAll(p);

    }
}
