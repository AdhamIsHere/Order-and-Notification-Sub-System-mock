package com.example.SDA_2.Data;

import com.example.SDA_2.Models.Product.Product;
import com.example.SDA_2.Models.Product.ProductHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ProductsDatabase {

    private static ProductsDatabase Productinstance = null;

    private ProductsDatabase() {

        addProduct(new Product("1234", "Hoodie", "Zara", "Clothes", 500),3);
        addProduct(new Product("5678", "Mobile", "Tradeline", "Electronics", 1500),5);
        addProduct(new Product("9101", "Neckless", "Lazurde", "Jewellery", 5000),10);

    }

    public static ProductsDatabase GetProductInstance() {
        if (Productinstance == null) {
            Productinstance = new ProductsDatabase();
        }
        return Productinstance;

    }

    public HashMap<Product, Integer> products = new HashMap<>();
    public HashMap<String, Integer> categoryCount = new HashMap<>();

    public boolean addProduct(Product p, int q) {

        try {
            if(products.containsKey(p)){
                int n = products.get(p);
                products.put(p,n+q);
                categoryCount.put(p.getCategory(),categoryCount.get(p.getCategory()) + q);
                return true;
            }
            products.put(p,q);
            categoryCount.put(p.getCategory(),q);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public boolean removeProduct(Product p, int q) {
        if(!products.containsKey(p)){
            return false;
        }
        int n = products.get(p);
        if (q > n) {
            return false;
        }
        products.put(p,n-q);
        int x = categoryCount.get(p.getCategory());
        categoryCount.put(p.getCategory(), x - q);
        return true;
    }

    public ProductHelper getProduct(String sn) {
        ProductHelper ph = new ProductHelper();
        for (Product p : products.keySet()) {
            if (p.getSerialNumber().equals(sn)) {
                ph.setProduct(p);
                ph.setQuantity(products.get(p));
                break;
            }
        }
        return ph;

    }
    public HashMap<Product,Integer> getAll(){
        return products;
    }
}
