package com.example.SDA_2.Data;

import com.example.SDA_2.Models.Product.Product;
import com.example.SDA_2.Models.Product.ProductHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ProductsDatabase
{
    private static ArrayList<Product> products = new ArrayList<>();
    private static ProductsDatabase Productinstance=null;
    private ProductsDatabase()
    {
       products = new ArrayList<>(Arrays.asList(
                new Product("1234", "Hoodie", "Zara", "Clothes", 500),
                new Product("5678", "Mobile", "Tradeline", "Electronics", 15000),
               new Product("9101", "Neckless", "Lazurde", "Jewellery", 5500)
        ));

    }
    public static ProductsDatabase GetProductInstance()
    {
        if (Productinstance == null)
        {
            Productinstance = new ProductsDatabase();
        }
        return Productinstance;

    }
    public static HashMap<String, Integer> productQuantity = new HashMap<>();
    public static HashMap<String, Integer> categoryCount = new HashMap<>();

    public static boolean addProduct(Product p, int q) {
        try {

            for (Product i : products) {
                if (i.getSerialNumber().equals(p.getSerialNumber())) {
                    int n = productQuantity.get(p.getSerialNumber());
                    productQuantity.put(p.getSerialNumber(), n + q);
                    categoryCount.put(p.getCategory(), categoryCount.get(p.getCategory()) + q);
                    return true;
                }
            }
            products.add(p);
            productQuantity.put(p.getSerialNumber(), q);
            categoryCount.put(p.getCategory(), q);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean removeProduct(Product p, int q) {
        if (!products.contains(p)) {
            return false;
        }
        int n = productQuantity.get(p.getSerialNumber());
        if (q > n) {
            return false;
        }
        productQuantity.put(p.getSerialNumber(), n - q);
        int x = categoryCount.get(p.getCategory());
        categoryCount.put(p.getCategory(), x - q);
        return true;
    }

    public static ProductHelper getProduct(String sn) {
        ProductHelper ph = new ProductHelper();
        boolean flag = false;
        for (Product p : products) {
            if (p.getSerialNumber().equals(sn)) {
                ph.setProduct(p);
                flag = true;
                break;
            }
        }
        if (!flag) {
            return ph;
        }
        ph.setQuantity(productQuantity.get(sn));
        return ph;
    }
}
