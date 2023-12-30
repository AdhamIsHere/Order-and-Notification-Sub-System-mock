package com.example.SDA_2.Data;

import com.example.SDA_2.Models.Product.Product;
import com.example.SDA_2.Models.Product.ProductHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ProductsDatabase {
    public static ArrayList<Product> products = new ArrayList<>(Arrays.asList(
            new Product("1234", "Caseoh", "fadl", "good", 500),
            new Product("1345", "Case123oh", "fa1dl", "goo3d", 5010)
    ));
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
