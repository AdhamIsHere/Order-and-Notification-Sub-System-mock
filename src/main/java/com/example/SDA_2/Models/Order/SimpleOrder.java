package com.example.SDA_2.Models.Order;

import com.example.SDA_2.Models.Customer;
import com.example.SDA_2.Models.Product.Product;
import com.example.SDA_2.Models.Product.ProductHelper;

import java.util.ArrayList;
import java.util.List;

public class SimpleOrder extends Order {
    ArrayList <ProductHelper> products;



    public SimpleOrder(String id,String ownerID,ArrayList<ProductHelper> products) {
        this.id = id;
        Total = calcTotal();
        this.ownerID=ownerID;
        this.products = products;
        this.owner = customerDatabase.getCustomerByUsername(ownerID);
        this.Total=calcTotal();

    }

    public SimpleOrder() {

    }

    public ArrayList<ProductHelper> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<ProductHelper> products) {
        this.products = products;
    }


    @Override
    public float calcTotal() {
        float sum=0;
        for(ProductHelper i : products)
        {
            sum += (i.getProduct().getPrice()*i.getQuantity());
        }
        System.out.println("Total price of order "+this.id+" is "+sum);
        Total=sum;
        return sum;
    }

    @Override
    public void printOrder() {

        for(ProductHelper i : products)
        {
            System.out.println(i.toString()) ;
        }

    }

    @Override
    public boolean addProduct(Customer c, ProductHelper... p) {
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
                ", owner=" + owner +
                ", owner='" + ownerID + '\'' +
                '}';
    }

    @Override
    public boolean deductFees() {
        placed=true;
        return customerDatabase.getCustomerByUsername(this.ownerID).deductFees(Total);
    }
    @Override
    public boolean shipOrder(float f) {
        if(placed){
            shipped=true;
            return customerDatabase.getCustomerByUsername(this.ownerID).deductFees(f);
        }
        return false;
    }

    @Override
    public boolean Cancelship(float f) {
        if(placed){
            shipped=false;
            customerDatabase.getCustomerByUsername(this.ownerID).addFees(f);
            return true;
        }
        return false;

    }
}
