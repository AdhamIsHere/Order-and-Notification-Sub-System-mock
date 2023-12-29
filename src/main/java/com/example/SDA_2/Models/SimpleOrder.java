package com.example.SDA_2.Models;

import java.util.ArrayList;
import java.util.List;

public class SimpleOrder extends Order {
    ArrayList <Product> products;

    SimpleOrder()
    {
        products = new ArrayList<>() ;
    }
    @Override
    public int calcTotal() {
        int sum=0;
        for(Product i : products)
        {
            sum += i.price;
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

    public void addProduct(Product... p) {
        products.addAll(List.of(p));

    }
}
